package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    TextField textDepositAmount;
    JButton depositButton, backButton;

    Deposit(String pin){

        //fetching the pin number from Signup3 class
        this.pin = pin;

        //Display the atm png picture according to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        //Display the deposit amount section
        JLabel labelDepositAmount = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        labelDepositAmount.setFont(new Font("Raleway", Font.BOLD, 16));
        labelDepositAmount.setForeground(Color.white);
        labelDepositAmount.setBounds(460, 180, 400, 35);
        l3.add(labelDepositAmount);

        //Creating textfield for input deposit amount
        textDepositAmount = new TextField();
        textDepositAmount.setFont(new Font("Raleway", Font.BOLD, 18));
        textDepositAmount.setForeground(Color.white);
        textDepositAmount.setBounds(460, 230, 320, 25);
        textDepositAmount.setBackground(new Color(65, 125, 128));
        l3.add(textDepositAmount);

        //Creating deposit button
        depositButton = new JButton("DEPOSIT");
        depositButton.setForeground(Color.white);
        depositButton.setBackground(new Color(65, 125, 128));
        depositButton.setBounds(750, 364, 100, 32);
        depositButton.addActionListener(this);
        l3.add(depositButton);

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
        try{
            String amount = textDepositAmount.getText();
            Date date = new Date();
            if (e.getSource() == depositButton){
                if (textDepositAmount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your amount");
                } else {
                    Conn con1 = new Conn();
                    con1.statement.executeUpdate("insert into depositAmount values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" deposit successfully");
                    setVisible(false);
                    new Main(pin);
                }
            } else if (e.getSource() == backButton){
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new Deposit("");
    }
}
