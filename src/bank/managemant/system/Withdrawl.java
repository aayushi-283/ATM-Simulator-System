package bank.managemant.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    JLabel l3, warning;

    Withdrawl(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm3.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("Maximum Withdrawl is 10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        textField .addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Allow only numeric input
                }
            }
        });
        l3.add(textField);

        b1 =new JButton("WITHDRAW");
        b1.setBounds(745,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 =new JButton("BACK");
        b2.setBounds(745,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource()==b1) {
                // Remove any previous warning message
                if (warning != null) {
                    l3.remove(warning);
                }
                if (textField.getText().equals("")) {
                  // JOptionPane.showMessageDialog(null, "Please Enter the amount you want to Withdraw");
                    warning  = new JLabel("! Please Enter the amount you want to Withdrawl");
                    warning.setBounds(460,285,400,28);
                    warning.setFont(new Font("System",Font.ITALIC,13));
                    warning.setForeground(Color.RED);
                    l3.add(warning);
                    // Revalidate and repaint to show the new label
                    l3.revalidate();
                    l3.repaint();
                }else if (Integer.parseInt(amount) > 10000) {
                    warning = new JLabel("! Cannot withdraw more than Rs. 10,000");
                    warning.setBounds(460, 295, 400, 28);
                    warning.setFont(new Font("System", Font.ITALIC, 13));
                    warning.setForeground(Color.RED);
                    l3.add(warning);
                    l3.revalidate();
                    l3.repaint();
                }
                else {
                    connection c = new connection();
                    ResultSet resultSet = c.s.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance ");
                        return;
                    } else {
                        c.s.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrawl','" + amount + "') ");
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited successfully.");
                        setVisible(false);
                        new main_Class(pin);
                    }
                }
            } else if (e.getSource()==b2) {
                setVisible(false);
                new main_Class(pin);
            }

        }catch (Exception E){
          E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}

//JUST FOR INFORMATION:
//Choose an SMS Gateway API
//Select an SMS gateway provider that offers Java support, such as:

//Twilio
//Nexmo (now Vonage)
//TextLocal
//Fast2SMS (popular in India)
//Each of these providers offers an API for sending SMS, and you'll need to sign up and get an API key and other credentials.
