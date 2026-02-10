package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Signup extends JFrame {

    JTextField textName, textFatherName;
    JDateChooser dateChooser;

    //Logic for generate 4 random numbers for Application Form
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    Signup(){
        super("APPLICATION FORM");

        //Set the size of Bank icon in the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page No. 01");
        label2.setBounds(330, 70, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details : ");
        label3.setBounds(290, 90, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);

        JLabel labelName = new JLabel("Name : ");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 190, 100, 30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        JLabel labelFatherName = new JLabel("Father's Name : ");
        labelFatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelFatherName.setBounds(100, 240, 200, 30);
        add(labelFatherName);

        textFatherName = new JTextField();
        textFatherName.setFont(new Font("Raleway", Font.BOLD, 14));
        textFatherName.setBounds(300, 240, 400, 30);
        add(textFatherName);

        JLabel DOB = new JLabel("Date Of Birth : ");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 340, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 340, 400, 30);
        add(dateChooser);







        //Design the frame size of the Signup page
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);

    }



    public static void main(String[] args) {
        new Signup();
    }
}
