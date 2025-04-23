package bank.managemant.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    Login() {
        super("Bank Management System");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(690, 50, 200, 200);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(1040, 650, 150, 180);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGrade", Font.BOLD, 42));
        label1.setBounds(580, 270, 450, 40);
        add(label1);

        label2 = new JLabel("Card NO:");
        label2.setFont(new Font("Raleway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(490, 338, 375, 35);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(665, 338, 230, 35);
        textField2.setFont(new Font("Arial", Font.BOLD, 19));
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textField2.getText().length() >= 16) {
                    e.consume(); // Ignore additional input
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Allow only numeric input
                }
            }
        });
        add(textField2);

        label3 = new JLabel("PIN:");
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(490, 403, 375, 35);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(665, 403, 230, 35);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 19));
        passwordField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (passwordField3.getPassword().length >= 4) {
                    e.consume(); // Ignore additional input
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Allow only numeric input
                }
            }
        });
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 17));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(665, 450, 110, 33);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 17));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(785, 450, 110, 33);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 17));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(665, 493, 230, 33);
        button3.addActionListener(this);
        add(button3);

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
       // Image bg1 = bg.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        Image bg1 = bg.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon bg2 = new ImageIcon(bg1);
        JLabel bgimage = new JLabel(bg2);
       // bgimage.setBounds(340, 145, 850, 480);
        bgimage.setBounds(0, 0, 1550, 830);
        add(bgimage);


        //setSize(850, 480);
       // setLocation(450, 200);
        getContentPane().setBackground( new Color(222,255,228));
        setSize(1550,1080);
        setLocation(0,0);
       // setUndecorated(true);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
              connection c= new connection();
              String cardno = textField2.getText();
              String pin = passwordField3.getText();
              String q = "select * from login where card_number ='"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultSet = c.s.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new main_Class(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card No or PIN.");
                }

            } else if (e.getSource() == button2) {
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == button3) {
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
        public static void main(String[] args){
            new Login();
        }
    }

