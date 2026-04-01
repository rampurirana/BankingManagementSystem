package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    //Declared global for implement into the signup page design
    JRadioButton r1, r2, r3, m1, m2, m3;
    JButton next;
    JTextField textName, textFatherName, textMotherName, textGmail, textAddress, textCity, textDistrict, textState, textPinCode;
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

        //Design the Application Form at the header with random form number
        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(160, 40, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        //Design the Page No.
        JLabel label2 = new JLabel("Page No. 01");
        label2.setBounds(620, 0, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 15));
        add(label2);

        //Design the personal details
        JLabel label3 = new JLabel("Personal Details : ");
        label3.setBounds(300, 100, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);

        //text input name for user name
        JLabel labelName = new JLabel("Name : ");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(120, 140, 100, 30);
        add(labelName);

        //text input field for user name
        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 140, 400, 30);
        add(textName);

        //text input name for user father name
        JLabel labelFatherName = new JLabel("Father's Name : ");
        labelFatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelFatherName.setBounds(120, 180, 200, 30);
        add(labelFatherName);

        //text input field for user father name
        textFatherName = new JTextField();
        textFatherName.setFont(new Font("Raleway", Font.BOLD, 14));
        textFatherName.setBounds(300, 180, 400, 30);
        add(textFatherName);

        //text input name for user mother name
        JLabel labelMotherName = new JLabel("Mother's Name : ");
        labelMotherName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMotherName.setBounds(120, 220, 200, 30);
        add(labelMotherName);

        //text input field for user mother name
        textMotherName = new JTextField();
        textMotherName.setFont(new Font("Raleway", Font.BOLD, 14));
        textMotherName.setBounds(300, 220, 400, 30);
        add(textMotherName);

        //text input name for user gmail
        JLabel gmail = new JLabel("Gmail : ");
        gmail.setFont(new Font("Raleway", Font.BOLD, 20));
        gmail.setBounds(120, 260, 200, 30);
        add(gmail);

        //text input field for user gmail
        textGmail = new JTextField();
        textGmail.setFont(new Font("Raleway", Font.BOLD, 14));
        textGmail.setBounds(300, 260, 400, 30);
        add(textGmail);

        //text input name for user date of birth
        JLabel DOB = new JLabel("Date Of Birth : ");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(120, 300, 200, 30);
        add(DOB);

        //Implement the Calendar for choose date of birth
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 300, 400, 30);
        add(dateChooser);

        //text input name for user gender
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(120, 340, 200, 30);
        add(gender);

        //Design the radio button for user gender
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 340, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(450, 340, 90, 30);
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(222, 255, 228));
        r3.setBounds(635, 340, 90, 30);
        add(r3);

        //Group the all gender button that is select one button at once
        ButtonGroup buttonGroupGender = new ButtonGroup();
        buttonGroupGender.add(r1);
        buttonGroupGender.add(r2);
        buttonGroupGender.add(r3);

        //Input name for user marital status
        JLabel maariageStatus = new JLabel("Marital Status : ");
        maariageStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maariageStatus.setBounds(120, 380, 200, 30);
        add(maariageStatus);

        //Design the radio button for user marital status
        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        m1.setBackground(new Color(222, 255, 228));
        m1.setBounds(300, 380, 100, 30);
        add(m1);

        m2 = new JRadioButton("Un Married");
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        m2.setBackground(new Color(222, 255, 228));
        m2.setBounds(450, 380, 110, 30);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        m3.setBackground(new Color(222, 255, 228));
        m3.setBounds(635, 380, 100, 30);
        add(m3);

        //Group the all marital status button that is select one button at once
        ButtonGroup buttonGroupMs = new ButtonGroup();
        buttonGroupMs.add(m1);
        buttonGroupMs.add(m2);
        buttonGroupMs.add(m3);

        //Input name for user address
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(120, 420, 200, 30);
        add(address);

        //text input field for user address
        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway", Font.BOLD, 14));
        textAddress.setBounds(300, 420, 400, 30);
        add(textAddress);

        //Input name for user city
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(120, 460, 200, 30);
        add(city);

        //text input field for user city
        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        textCity.setBounds(300, 460, 400, 30);
        add(textCity);

        //text input name for user district
        JLabel district = new JLabel("District : ");
        district.setFont(new Font("Raleway", Font.BOLD, 20));
        district.setBounds(120, 500, 200, 30);
        add(district);

        //text input field for user district
        textDistrict = new JTextField();
        textDistrict.setFont(new Font("Raleway", Font.BOLD, 14));
        textDistrict.setBounds(300, 500, 400, 30);
        add(textDistrict);

        //text input name for user state
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(120, 540, 200, 30);
        add(state);

        //text input field for user state
        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        textState.setBounds(300, 540, 400, 30);
        add(textState);

        //text input name for user Pin code
        JLabel pinCode = new JLabel("Pin Code : ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(120, 580, 200, 30);
        add(pinCode);

        //text input field for user pin code
        textPinCode = new JTextField();
        textPinCode.setFont(new Font("Raleway", Font.BOLD, 14));
        textPinCode.setBounds(300, 580, 400, 30);
        add(textPinCode);

        //Desinging the next button that is clickable for next page
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(400, 630, 80, 30);
        next.addActionListener(this);
        add(next);

        //Design the frame size of the Signup page
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fornNo = first;
        String name = textName.getText();
        String fName = textFatherName.getText();
        String mName = textMotherName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gen = null;
        if(r1.isSelected()){
            gen = "Male";
        } else if(r2.isSelected()){
            gen = "Female";
        } else if(r3.isSelected()) {
            gen = "Other";
        }

        String email = textGmail.getText();

        String married = null;
        if(m1.isSelected()){
            married = "Married";
        } else if(m2.isSelected()) {
            married = "Un Married";
        } else if(m3.isSelected()) {
            married = "Other";
        }

        String address = textAddress.getText();
        String city = textCity.getText();
        String district = textDistrict.getText();
        String state = textState.getText();
        String pinCode = textPinCode.getText();

        try{
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter all data");
            } else {
                Conn con1 = new Conn();
                String q = "insert into signupData values('"+fornNo+"', '"+name+"', '"+fName+"', '"+mName+"', '"+dob+"', '"+gen+"', '"+email+"', '"+married+"', '"+address+"', '"+city+"', '"+district+"', '"+state+"', '"+pinCode+"')";
                con1.statement.executeUpdate(q);
                new Signup2();
                setVisible(false);
            }

        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
