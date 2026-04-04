package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup3 extends JFrame implements ActionListener {

    String formNo;
    JRadioButton r1, r2, r3;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, cancel;

    Signup3(){
        super("APPLICATION FORM");

        //Set the size of the bank in the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        //Retrive the form no. from Signup page using of databases
        this.formNo = formNo;

        //Design the apllication form no in the top of the page
        JLabel labelFormNo = new JLabel("APPLICATION FORM NO.");
        labelFormNo.setBounds(160, 40, 600, 40);
        labelFormNo.setFont(new Font("Raleway", Font.BOLD, 38));
        add(labelFormNo);

        //Pass the form no.
        JLabel labelShowFormNo = new JLabel(formNo);
        labelShowFormNo.setBounds(650, 40, 600, 40);
        labelShowFormNo.setFont(new Font("Raleway", Font.BOLD, 38));
        add(labelShowFormNo);

        //Design the page no. section
        JLabel labelPage = new JLabel("Page No. 03");
        labelPage.setFont(new Font("Raleway", Font.BOLD, 15));
        labelPage.setBounds(620, 0, 600, 30);
        add(labelPage);

        //Design the accounts datails label
        JLabel labelAccount = new JLabel("Account Details : ");
        labelAccount.setFont(new Font("Raleway", Font.BOLD, 22));
        labelAccount.setBounds(300, 100, 600, 30);
        add(labelAccount);

        //Design the account type label
        JLabel labelAccountType = new JLabel("Account Type : ");
        labelAccountType.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAccountType.setBounds(120, 140, 150, 30);
        add(labelAccountType);

        //Radio button for selecting account type
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(215, 252, 252));
        r1.setBounds(280, 140, 140, 30);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(215, 252, 252));
        r2.setBounds(428, 140, 140, 30);
        add(r2);

        r3 = new JRadioButton("Salary Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(215, 252, 252));
        r3.setBounds(576, 140, 140, 30);
        add(r3);

        //Implement the button group that is selcet one button at once time
        ButtonGroup buttonAccount = new ButtonGroup();
        buttonAccount.add(r1);
        buttonAccount.add(r2);
        buttonAccount.add(r3);

        //Design the card number label
        JLabel labelCardNum = new JLabel("Card No. :");
        labelCardNum.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCardNum.setBounds(120, 200, 150, 30);
        add(labelCardNum);

        //Design the your card number label
        JLabel labelYourCardNum = new JLabel("(Your 16-digit Card Number)");
        labelYourCardNum.setFont(new Font("Raleway", Font.BOLD, 12));
        labelYourCardNum.setBounds(120, 220, 250, 30);
        add(labelYourCardNum);

        //Design the show card number label
        JLabel labelShowCardNum = new JLabel("XXXX-XXXX-XXXX-1435");
        labelShowCardNum.setFont(new Font("Raleway", Font.BOLD, 18));
        labelShowCardNum.setBounds(320, 200, 250, 30);
        add(labelShowCardNum);

        //Design the card number functionaliy function label
        JLabel labelFunctionality = new JLabel("It would appears on atm card, cheque book, and statements");
        labelFunctionality.setFont(new Font("Raleway", Font.BOLD, 12));
        labelFunctionality.setBounds(320, 220, 500, 30);
        add(labelFunctionality);

        //Design the pin label
        JLabel labelPin = new JLabel("PIN :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(120, 260, 100, 30);
        add(labelPin);

        //Design the store show pin number label
        JLabel labelShowPin = new JLabel("XXXX");
        labelShowPin.setFont(new Font("Raleway", Font.BOLD, 18));
        labelShowPin.setBounds(320, 260, 100, 30);
        add(labelShowPin);

        //Design the your 4-digit pin number label
        JLabel labelYourPin = new JLabel("Your 4-digit Pin Number");
        labelYourPin.setFont(new Font("Raleway", Font.BOLD, 12));
        labelYourPin.setBounds(120, 280, 250, 30);
        add(labelYourPin);

        //Design the services required label
        JLabel labelService = new JLabel("Services Required :");
        labelService.setFont(new Font("Raleway", Font.BOLD, 20));
        labelService.setBounds(120, 340, 200, 30);
        add(labelService);

        //Creating the checkbox for user required services that is selected multiple choice at once time
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(new Color(215, 252, 252));
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(120, 370, 150, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215, 252, 252));
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 370, 150, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(215, 252, 252));
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(580, 370, 150, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alert");
        c4.setBackground(new Color(215, 252, 252));
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(120, 400, 150, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(215, 252, 252));
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(350, 400, 150, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(215, 252, 252));
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(580, 400, 150, 30);
        add(c6);

        //Create the declaration checkbox label that is ccepted by the user
        JCheckBox labelDeclare = new JCheckBox("I hereby declare that the above-entered details are correct to the best of my knowledge.", true);
        labelDeclare.setBackground(new Color(215, 252, 252));
        labelDeclare.setFont(new Font("Raleway", Font.BOLD, 13));
        labelDeclare.setBounds(120, 450, 800, 20);
        add(labelDeclare);

        //Create cancel button
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(320, 490, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        //Create submit button
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(450, 490, 100, 30);
        submit.addActionListener(this);
        add(submit);

        //Implement the page form details
        getContentPane().setBackground(new Color(215, 252, 252));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Signup3();
    }
}
