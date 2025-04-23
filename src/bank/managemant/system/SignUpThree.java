package bank.managemant.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton s,c;
    String form_no;
    SignUpThree(String form_no){
        super("Application Form No:"+SignupOne.random);

        this.form_no = form_no;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM card.png"));
        Image i5 = i4.getImage().getScaledInstance(480, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel imagee = new JLabel(i6);
        imagee.setBounds(785, 465, 480, 300);
        add(imagee);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/provider.png"));
        Image i8 = i7.getImage().getScaledInstance(265, 275, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel iimagee = new JLabel(i9);
        iimagee.setBounds(1268, 400, 265, 275);
        add(iimagee);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/Online Banking 1.png"));
        Image i11= i10.getImage().getScaledInstance(320, 275, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel iimageee = new JLabel(i12);
        iimageee.setBounds(990, 150, 320, 275);
        add(iimageee);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/Estatement.png"));
        Image i14= i13.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel iiimageee = new JLabel(i15);
        iiimageee.setBounds(1320, 150, 300,300);
        add(iiimageee);


        JLabel l1 = new JLabel("Page 3: ACCOUNT DETAILS");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(384,60,400,40);
        add(l1);

        JLabel l3 = new JLabel("ACCOUNT TYPE:");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setBounds(300,160,200,19);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(300,200,150,19);
        r1.setBackground(new Color(44,117,152));
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(550,200,300,19);
        r2.setBackground(new Color(44,117,152));
        add(r2);

        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(300,240,250,19);
        r3.setBackground(new Color(44,117,152));
        add(r3);

        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(550,240,250,19);
        r4.setBackground(new Color(44,117,152));
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4= new JLabel("Card Number:");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(300,320,200,30);
        add(l4);

        JLabel l5= new JLabel("(Your 16-digit card Number)");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l5.setBounds(300,350,200,20);
        add(l5);

        JLabel l6= new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway",Font.BOLD,12));
        l6.setBounds(530,320,250,30);
        add(l6);

        JLabel l7= new JLabel("It would appear on ATM Card / Cheque book and Statements.");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(530,350,500,30);
        add(l7);

        JLabel l8= new JLabel("PIN:");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(300,390,200,30);
        add(l8);

        JLabel l9= new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(530,390,200,30);
        add(l9);

        JLabel l10= new JLabel("(4-digit Passward)");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(300,420,200,20);
        add(l10);

        JLabel l11= new JLabel("Services Required:");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(300,470,200,30);
        add(l11);

        c1 =new JCheckBox("ATM CARD");
        c1.setBackground(new Color(44,117,152));
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(300,520,200,30);
        add(c1);

        c2 =new JCheckBox("Internet Banking");
        c2.setBackground(new Color(44,117,152));
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(550,520,200,30);
        add(c2);

        c3 =new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(44,117,152));
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(300,570,200,30);
        add(c3);

        c4 =new JCheckBox("Email Alerts");
        c4.setBackground(new Color(44,117,152));
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(550,570,200,30);
        add(c4);

        c5 =new JCheckBox("Cheque Book");
        c5.setBackground(new Color(44,117,152));
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(300,620,200,30);
        add(c5);
        c6 =new JCheckBox("E-Statement");
        c6.setBackground(new Color(44,117,152));
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(550,620,200,30);
        add(c6);

        c7 =new JCheckBox("I here by decleares that the above entred details correct to the best of my knowledge.",true);
        c7.setBackground(new Color(44,117,152));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(300,700,600,20);
        add(c7);

        JLabel l12= new JLabel("FORM NO:");
        l12.setFont(new Font("Raleway", Font.BOLD,25));
        l12.setBounds(1250,10,125,33);
        add(l12);

        JLabel l13= new JLabel(form_no);
        l13.setFont(new Font("Raleway", Font.BOLD,25));
        l13.setBounds(1376,10,100,33);
        add(l13);

        s = new JButton("Submit");
        s.setFont(new Font("Raleway",Font.BOLD,14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(450,740,100,30);
        s.addActionListener(this);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway",Font.BOLD,14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(620,740,100,30);
        c.addActionListener(this);
        add(c);

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        // Image bg1 = bg.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        Image bg1 = bg.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon bg2 = new ImageIcon(bg1);
        JLabel bgimage = new JLabel(bg2);
        // bgimage.setBounds(340, 145, 850, 480);
        bgimage.setBounds(0, 0, 1550, 830);
        add(bgimage);

        setLayout(null);
        getContentPane().setBackground( new Color(222,255, 234));
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String atype = "";
    if (r1.isSelected()){
        atype = "Saving Account";
    } else if (r2.isSelected()) {
        atype = "Fixed Deposit Account";
    } else if (r3.isSelected()) {
        atype="Current Account";
    } else if (r4.isSelected()) {
        atype ="Recurring Deposit Account";
    }

    Random ran = new Random();
    long first7 = (ran.nextLong() % 90000000L)+1409963000000000L;
    String cardno = "" + Math.abs(first7);
        while (cardno.length() < 16) {
            int digit = ran.nextInt(10); // Generates a random digit (0-9)
            cardno += digit;
        }

    int pinNumber = ran.nextInt(10000); // Generates a number between 0 and 9999
    String  pin = String.format("%04d", pinNumber);      // Formats the number to 4 digits


        String fac ="";
    if (c1.isSelected()){
        fac+="ATM CARD";
    }
    if (c2.isSelected()) {
        fac+= ", Internet Banking";
    }
    if (c3.isSelected()) {
        fac+= ", Mobile Banking";
    }
    if (c4.isSelected()) {
        fac+= ", Email Alerts";
    }
    if (c5.isSelected()) {
        fac+= ", Cheque Book";
    }
    if (c6.isSelected()) {
        fac += ", E-Statement";
    }

    try{
        if (e.getSource()==s){
            if (atype.equals("")){
                JOptionPane.showMessageDialog(null,"Fill All The Fields.");
            } else if (c7.equals(false)) {
                JOptionPane.showMessageDialog(null,"Please Marks as check in the declaration box.");
            } else{
                connection c1 = new connection();
                String q1 = "insert into signupthree(form_no, account_type, card_number, pin, facility)" +
                             "values('"+form_no+"','"+atype+"','"+cardno+"','"+pin+"','"+fac+"')";
                String q2 = "insert into login(form_no, card_number, pin)" +"values('"+form_no+"', '"+cardno+"', '"+pin+"')";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Card Number: "+cardno+"\nPIN: "+pin);
                new Deposit(pin);
                setVisible(false);
            }
        } else if (e.getSource()==c) {
            System.exit(0);
        }

    }catch(Exception E){
        E.printStackTrace();
    }

    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
