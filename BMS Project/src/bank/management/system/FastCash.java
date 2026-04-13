package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pin;
    JButton lB1, lB2, lB3, rB1, rB2, rB3, rB4;


    FastCash(String pin){
        this.pin = pin;

        //Display the atm png picture according to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        //Display the select amount section
        JLabel labelSelect = new JLabel("SELECT YOUR WITHDRAWAL AMOUNT");
        labelSelect.setFont(new Font("Raleway", Font.BOLD, 16));
        labelSelect.setForeground(Color.white);
        labelSelect.setBounds(470, 180, 400, 35);
        l3.add(labelSelect);

        //Creating deposit button
        lB1 = new JButton("Rs. 100");
        lB1.setForeground(Color.white);
        lB1.setBackground(new Color(65, 125, 128));
        lB1.setBounds(410, 271, 110, 32);
        lB1.addActionListener(this);
        l3.add(lB1);

        //Creating fast cash button
        lB2 = new JButton("Rs. 500");
        lB2.setForeground(Color.white);
        lB2.setBackground(new Color(65, 125, 128));
        lB2.setBounds(410, 318, 110, 32);
        lB2.addActionListener(this);
        l3.add(lB2);

        //Creating PIN CHANGE button
        lB3 = new JButton("Rs. 1000");
        lB3.setForeground(Color.white);
        lB3.setBackground(new Color(65, 125, 128));
        lB3.setBounds(410, 365, 110, 32);
        lB3.addActionListener(this);
        l3.add(lB3);

        //Creating cash withdrawal button
        rB1 = new JButton("Rs. 2000");
        rB1.setForeground(Color.white);
        rB1.setBackground(new Color(65, 125, 128));
        rB1.setBounds(740, 271, 110, 32);
        rB1.addActionListener(this);
        l3.add(rB1);

        //Creating mini statement button
        rB2 = new JButton("Rs. 5000");
        rB2.setForeground(Color.white);
        rB2.setBackground(new Color(65, 125, 128));
        rB2.setBounds(740, 318, 110, 32);
        rB2.addActionListener(this);
        l3.add(rB2);

        //Creating BALANCE ENQUIRY button
        rB3 = new JButton("Rs. 10000");
        rB3.setForeground(Color.white);
        rB3.setBackground(new Color(65, 125, 128));
        rB3.setBounds(740, 365, 110, 32);
        rB3.addActionListener(this);
        l3.add(rB3);

        //Creating EXIT button
        rB4 = new JButton("BACK");
        rB4.setForeground(Color.white);
        rB4.setBackground(new Color(65, 125, 128));
        rB4.setBounds(740, 412, 110, 32);
        rB4.addActionListener(this);
        l3.add(rB4);

        //set the frame size of the page
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rB4){
            setVisible(false);
            new Main(pin);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn con = new Conn();
            Date date = new Date();
            try {
                ResultSet resultSet = con.statement.executeQuery("select * from depositAmount where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                } String num = "17";

                if (e.getSource() != rB4 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                con.statement.executeUpdate("insert into depositAmount values('" + pin + "', '" + date + "', 'Withdraw', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

            } catch (Exception E){
                E.printStackTrace();
            }

            setVisible(false);
            new Main(pin);
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
