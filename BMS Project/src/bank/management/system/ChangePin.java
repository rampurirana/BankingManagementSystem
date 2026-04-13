package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {

    String pin;
    JButton changePinButton, backButton;
    JPasswordField password, confirmPassword;


    ChangePin(String pin){
        this.pin = pin;

        //Display the atm png picture according to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        //Display the change your pin section
        JLabel labelDepositAmount = new JLabel("CHANGE YOUR PIN");
        labelDepositAmount.setFont(new Font("Raleway", Font.BOLD, 16));
        labelDepositAmount.setForeground(Color.white);
        labelDepositAmount.setBounds(558, 175, 400, 35);
        l3.add(labelDepositAmount);

        //Display the new pin section
        JLabel labelNewPin = new JLabel("New Pin :");
        labelNewPin.setFont(new Font("Raleway", Font.BOLD, 14));
        labelNewPin.setForeground(Color.white);
        labelNewPin.setBounds(470, 205, 400, 35);
        l3.add(labelNewPin);

        //Creating password field for new pin
        password = new JPasswordField();
        password.setFont(new Font("Raleway", Font.BOLD, 18));
        password.setForeground(Color.white);
        password.setBounds(600, 214, 100, 20);
        password.setBackground(new Color(65, 125, 128));
        l3.add(password);

        //Creatingconfirm new pin section
        JLabel labelConfirmPin = new JLabel("Confirm New Pin :");
        labelConfirmPin.setFont(new Font("Raleway", Font.BOLD, 14));
        labelConfirmPin.setForeground(Color.white);
        labelConfirmPin.setBounds(470, 230, 400, 35);
        l3.add(labelConfirmPin);

        //Creating confirm password field for new pin
        confirmPassword = new JPasswordField();
        confirmPassword.setFont(new Font("Raleway", Font.BOLD, 18));
        confirmPassword.setForeground(Color.white);
        confirmPassword.setBounds(600, 239, 100, 20);
        confirmPassword.setBackground(new Color(65, 125, 128));
        l3.add(confirmPassword);

        //Creating change pin button
        changePinButton = new JButton("CHANGE PIN");
        changePinButton.setForeground(Color.white);
        changePinButton.setBackground(new Color(65, 125, 128));
        changePinButton.setBounds(742, 364, 108, 32);
        changePinButton.addActionListener(this);
        l3.add(changePinButton);

        //Creating back button
        backButton = new JButton("BACK");
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setBounds(742, 411, 108, 32);
        backButton.addActionListener(this);
        l3.add(backButton);



        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1 = password.getText();
            String pin2 = confirmPassword.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not matched");
                return;
            }

            if (e.getSource() == changePinButton){
                if (password.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your new pin");
                    return;
                }
                if (confirmPassword.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter your new pin");
                    return;
                }

                Conn con = new Conn();
                String q1 = "update depositAmount set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupDataThree set pin = '"+pin1+"' where pin = '"+pin+"'";

                con.statement.executeUpdate(q1);
                con.statement.executeUpdate(q2);
                con.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new Main(pin);
            } else if (e.getSource() == backButton){
                setVisible(false);
                new Main(pin);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ChangePin("");
    }
}
