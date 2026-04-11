package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    Login(){
        super("Bank Management System");

        //Set the size of Bank icon in the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        //Set the size of bank card in the frame
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 350, 100, 100);
        add(iimage);

        //Display the welcome message
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 120, 450, 40);
        add(label1);

        //Display the Card NO. Area
        label2 = new JLabel("Card No.");
        label2.setFont(new Font("Raleway", Font.BOLD, 28));
        label2.setForeground(Color.white);
        label2.setBounds(180, 190, 375, 30);
        add(label2);

        //Create the text field of the Card No.
        textField2 = new JTextField(15);
        textField2.setBounds(300, 190, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);

        //Display the Pin No. Area
        label3 = new JLabel("PIN NO.");
        label3.setFont(new Font("Raleway", Font.BOLD ,28));
        label3.setForeground(Color.white);
        label3.setBounds(180, 235, 375, 30);
        add(label3);

        //Create the textfield of the Password
        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(300, 235, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        //Design the Signin Button
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300, 290, 100, 30);
        button1.addActionListener(this);
        add(button1);

        //Design the Clear Button
        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.white);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430, 290, 100, 30);
        button2.addActionListener(this);
        add(button2);

        //Design the Signup Button
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.white);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300, 330, 230, 30);
        button3.addActionListener(this);
        add(button3);

        //Set the background image
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);

        //Set up the layout of the Signin Page
        setLayout(null);
        setSize(850, 480);
        setLocation(350, 200);
//        setUndecorated(true);
        setVisible(true);
    }

    //Add the event Listner of the all three button
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Performing the all three buttons according the button work
            if(e.getSource() == button1){
                Conn con1 = new Conn();
                String cardNo = textField2.getText();
                String pin = passwordField3.getText();
                String q = "Select * from login where card_number = '"+cardNo+"' and pin = '"+pin+"'";
                ResultSet resultSet = con1.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new Main(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrecct Card Number or Pin");
                }

            } else if(e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            } else if(e.getSource() == button3){
                new Signup();
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
