package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {

    String formNo;
    JComboBox comboBox, comboBox1, comboBox2, comboBox3, comboBox4;
    JTextField textPanCard, textAadharCard;
    JRadioButton r1, r2, r3, r4;
    JButton next;

    Signup2(String first){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        this.formNo = formNo;

        JLabel labelFormNo = new JLabel("APPLICATION FORM NO.");
        labelFormNo.setBounds(160, 40, 600, 40);
        labelFormNo.setFont(new Font("Raleway", Font.BOLD, 38));
        add(labelFormNo);

        JLabel labelShowFormNo = new JLabel(formNo);
        labelShowFormNo.setBounds(650, 40, 600, 40);
        labelShowFormNo.setFont(new Font("Raleway", Font.BOLD, 38));
        add(labelShowFormNo);

        JLabel labelPage = new JLabel("Page No. 02");
        labelPage.setFont(new Font("Raleway", Font.BOLD, 15));
        labelPage.setBounds(620, 0, 600, 30);
        add(labelPage);

        JLabel labelAddDetails = new JLabel("Additional Details : ");
        labelAddDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        labelAddDetails.setBounds(300, 100, 600, 30);
        add(labelAddDetails);

        JLabel labelReligion = new JLabel("Religion : ");
        labelReligion.setFont(new Font("Raleway", Font.BOLD, 20));
        labelReligion.setBounds(120, 140, 100, 30);
        add(labelReligion);

        String religion[] = {"Hindu", "Mushlim", "Sikh", "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(252, 208, 76));
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(300, 140, 400, 30);
        add(comboBox);

        JLabel labelCategory = new JLabel("Category :");
        labelCategory.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCategory.setBounds(120, 180, 100, 30);
        add(labelCategory);

        String category[] = {"General", "SC", "ST", "OBC", "Other"};
        comboBox1 = new JComboBox(category);
        comboBox1.setBackground(new Color(252, 208, 76));
        comboBox1.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox1.setBounds(300, 180, 400, 30);
        add(comboBox1);

        JLabel labelIncome = new JLabel("Income : ");
        labelIncome.setFont(new Font("Raleway", Font.BOLD, 20));
        labelIncome.setBounds(120, 220, 100, 30);
        add(labelIncome);

        String income[] = {"Below ₹1 Lakh", "₹1 Lakh - ₹3 Lakh", "₹3 Lakh - ₹6 Lakh", "₹6 Lkah - ₹10 Lakh", "₹10 Lakh+"};
        comboBox2 = new JComboBox(income);
        comboBox2.setBackground(new Color(252, 208, 76));
        comboBox2.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox2.setBounds(300, 220, 400, 30);
        add(comboBox2);

        JLabel labelEducation = new JLabel("Educational :");
        labelEducation.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEducation.setBounds(120, 260, 124, 30);
        add(labelEducation);

        String education[] = {"10th", "12th", "Diploma", "UG", "PG", "PHD", "Other"};
        comboBox3 = new JComboBox(education);
        comboBox3.setBackground(new Color(252, 208, 76));
        comboBox3.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox3.setBounds(300, 260, 400, 30);
        add(comboBox3);

        JLabel labelOccupation = new JLabel("Occupation :");
        labelOccupation.setFont(new Font("Raleway", Font.BOLD, 20));
        labelOccupation.setBounds(120, 300, 120, 30);
        add(labelOccupation);

        String occupation[] = {"Student", "Salaried", "Self-Employed", "Business", "Retired", "Other"};
        comboBox4 = new JComboBox(occupation);
        comboBox4.setBackground(new Color(252, 208, 76));
        comboBox4.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox4.setBounds(300, 300, 400, 30);
        add(comboBox4);

        JLabel labelPanCard = new JLabel("Pan Card No. :");
        labelPanCard.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPanCard.setBounds(120, 340, 140, 30);
        add(labelPanCard);

        textPanCard = new JTextField();
        textPanCard.setFont(new Font("Raleway", Font.BOLD, 14));
        textPanCard.setBounds(300, 340, 400, 30);
        add(textPanCard);

        JLabel labelAadharCard = new JLabel("Aadhar No. :");
        labelAadharCard.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAadharCard.setBounds(120, 380, 120, 30);
        add(labelAadharCard);

        textAadharCard = new JTextField();
        textAadharCard.setFont(new Font("Raleway", Font.BOLD, 14));
        textAadharCard.setBounds(300, 380, 400, 30);
        add(textAadharCard);

        JLabel labelCitizen = new JLabel("Senior Citizen :");
        labelCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCitizen.setBounds(120, 420, 150, 30);
        add(labelCitizen);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(252, 208, 76));
        r1.setBounds(350, 420, 100, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(252, 208, 76));
        r2.setBounds(450, 420, 100, 30);
        add(r2);

        ButtonGroup buttonCitizen = new ButtonGroup();
        buttonCitizen.add(r1);
        buttonCitizen.add(r2);

        JLabel labelAccount = new JLabel("Existing Account :");
        labelAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAccount.setBounds(120, 460, 200, 30);
        add(labelAccount);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Ralelway", Font.BOLD, 14));
        r3.setBackground(new Color(252, 208, 76));
        r3.setBounds(350, 460, 100, 30);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(new Color(252, 208, 76));
        r4.setBounds(450, 460, 100, 30);
        add(r4);

        ButtonGroup buttonAccount = new ButtonGroup();
        buttonAccount.add(r3);
        buttonAccount.add(r4);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(400, 510, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(252, 208, 76));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
