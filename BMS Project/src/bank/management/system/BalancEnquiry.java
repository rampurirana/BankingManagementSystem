package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalancEnquiry extends JFrame implements ActionListener {

    String pin;
    JLabel remBalance;
    JButton backButton;

    BalancEnquiry(String pin){

        //fetching the pin number from Main class
        this.pin = pin;

        //Display the atm png picture according to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        //Display the current balance section
        JLabel labelBalance = new JLabel("Your current balance is Rs.");
        labelBalance.setFont(new Font("Raleway", Font.BOLD, 17));
        labelBalance.setForeground(Color.white);
        labelBalance.setBounds(465, 180, 700, 35);
        l3.add(labelBalance);

        //Store the remaining balance
        remBalance = new JLabel();
        remBalance.setFont(new Font("Raleway", Font.BOLD, 14));
        remBalance.setForeground(Color.white);
        remBalance.setBounds(465, 210, 700, 20);
        l3.add(remBalance);

        //Creating back button
        backButton = new JButton("BACK");
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setBounds(750, 411, 100, 32);
        backButton.addActionListener(this);
        l3.add(backButton);


        int balance = 0;
        try {
            Conn con = new Conn();
            ResultSet resultSet = con.statement.executeQuery("select * from depositAmount where pin = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception E){
            E.printStackTrace();
        }

        remBalance.setText(""+balance);


        //set the frame size of the page
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Main(pin);

    }

    public static void main(String[] args) {
        new BalancEnquiry("");
    }
}
