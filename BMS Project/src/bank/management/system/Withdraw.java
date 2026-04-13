package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    String pin;
    TextField textWithdrawAmount;
    JButton withdrawButton, backButton;

    Withdraw(String pin){

        //fetching the pin number from Main class
        this.pin = pin;

        //Display the atm png picture according to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        //Display the withdrawal amount section
        JLabel labelAmount = new JLabel("MAXIMUM WITHDRAWAL IS RS. 10000");
        labelAmount.setFont(new Font("Raleway", Font.BOLD, 17));
        labelAmount.setForeground(Color.white);
        labelAmount.setBounds(465, 180, 700, 35);
        l3.add(labelAmount);

        //Display the enter withdraw amount section
        JLabel labelWithdrawAmount = new JLabel("PLEASE ENTER YOUR WITHDRAW AMOUNT");
        labelWithdrawAmount.setFont(new Font("Raleway", Font.BOLD, 14));
        labelWithdrawAmount.setForeground(Color.white);
        labelWithdrawAmount.setBounds(465, 210, 700, 20);
        l3.add(labelWithdrawAmount);

        //Creating textfield for input withdraw amount
        textWithdrawAmount = new TextField();
        textWithdrawAmount.setFont(new Font("Raleway", Font.BOLD, 18));
        textWithdrawAmount.setForeground(Color.white);
        textWithdrawAmount.setBounds(460, 230, 320, 25);
        textWithdrawAmount.setBackground(new Color(65, 125, 128));
        l3.add(textWithdrawAmount);

        //Creating withdraw button
        withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setForeground(Color.white);
        withdrawButton.setBackground(new Color(65, 125, 128));
        withdrawButton.setBounds(750, 364, 100, 32);
        withdrawButton.addActionListener(this);
        l3.add(withdrawButton);

        //Creating back button
        backButton = new JButton("BACK");
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setBounds(750, 411, 100, 32);
        backButton.addActionListener(this);
        l3.add(backButton);

        //set the frame size of the page
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            try {
                String amount = textWithdrawAmount.getText();
                Date date = new Date();
                if (textWithdrawAmount.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter valid amount");
                } else {
                    Conn con = new Conn();
                    ResultSet resultSet = con.statement.executeQuery("select * from depositAmount where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    con.statement.executeUpdate("insert into depositAmount values('" + pin + "', '" + date + "', 'Withdraw', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new Main(pin);
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == backButton){
            setVisible(false);
            new Main(pin);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");

    }
}
