package bank.managemant.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    String pin;
    JPasswordField p1,p2;
    Pin(String pin){

        this.pin =pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm3.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN:");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(350,180,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("New PIN:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(350,220,150,35);
        l3.add(label2);

        p1= new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(520,220,200,32);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        p1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (p1.getPassword().length >= 4) {
                    e.consume(); // Ignore additional input
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Allow only numeric input
                }
            }
        });
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setBounds(350,255,400,35);
        l3.add(label3);

        p2= new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(520,255,200,32);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        p2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (p2.getPassword().length >= 4) {
                    e.consume(); // Ignore additional input
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Allow only numeric input
                }
            }
        });
        l3.add(p2);

        b1 =new JButton("CHANGE");
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
       setLayout(null);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin2.equals(pin1)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match.");
                return;
            }
            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter new PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter new PIN");
                    return;
                }
                connection c = new connection();
                String q1 = "update bank set pin= '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin= '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin= '"+pin1+"' where pin = '"+pin+"'";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed Successfully.");
               setVisible(false);
                new main_Class(pin);
            } else if (e.getSource()==b2) {
                new main_Class(pin);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
     new Pin("");
    }
}
