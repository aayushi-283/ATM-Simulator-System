package bank.managemant.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUpTwo extends JFrame  implements ActionListener {
    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textpan,textaadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;
    String form_no;
    String pan;
    SignUpTwo(String form_no){
        super("Application Form No:"+SignupOne.random);

        this.form_no = form_no;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        this.form_no = form_no;
        JLabel l1 = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        l1.setFont(new Font("Raleway", Font.BOLD,28));
        l1.setBounds(584,60,650,28);
        add(l1);

        JLabel l3 = new JLabel("RELIGION:");
        l3.setFont(new Font("Raleway", Font.BOLD,19));
        l3.setBounds(500,180,100,30);
        add(l3);
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        comboBox =new JComboBox(religion);
        comboBox.setBackground(new Color(44,117,152));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(750,180,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("CATEGORY:");
        l4.setFont(new Font("Raleway", Font.BOLD,19));
        l4.setBounds(500,230,120,30);
        add(l4);

        String category[] = {"General","OBC","SC","ST","Other"};
        comboBox2 =new JComboBox(category);
        comboBox2.setBackground(new Color(44,117,152));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(750,230,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("INCOME:");
        l5.setFont(new Font("Raleway", Font.BOLD,19));
        l5.setBounds(500,280,120,30);
        add(l5);

        String income[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,00","Above 10,00,00"};
        comboBox3 =new JComboBox(income);
        comboBox3.setBackground(new Color(44,117,152));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(750,280,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("EDUCATIONAL");
        l6.setFont(new Font("Raleway", Font.BOLD,19));
        l6.setBounds(500,330,160,30);
        add(l6);

        JLabel l61 = new JLabel("DETAILS:");
        l61.setFont(new Font("Raleway", Font.BOLD,19));
        l61.setBounds(500,350,160,30);
        add(l61);

        String educational[] = {"Non-Gratuate","Graduate","post-Graduate","Doctrate","Others"};
        comboBox4 =new JComboBox(educational);
        comboBox4.setBackground(new Color(44,117,152));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(750,340,320,30);
        add(comboBox4);

        JLabel l7 = new JLabel("OCCUPATION:");
        l7.setFont(new Font("Raleway", Font.BOLD,19));
        l7.setBounds(500,400,160,30);
        add(l7);

        String occupation[] = {"Salaried","Self-Employed","Bussiness","Student","Retiered"};
        comboBox5 =new JComboBox(occupation);
        comboBox5.setBackground(new Color(44,117,152));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(750,400,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN NUMBER:");
        l8.setFont(new Font("Raleway", Font.BOLD,19));
        l8.setBounds(500,450,160,30);
        add(l8);

        textpan = new JTextField();
        textpan.setFont(new Font("Raleway", Font.BOLD,19));
        textpan.setBounds(750,450,320,30);
      //  textpan.setBackground(Color.F5F5F5);
        textpan.setBackground(new Color(0xF5C0B2B2, true)); // Light gray background
        textpan.setForeground(new Color(0x002244));
        textpan.setBorder(BorderFactory.createLineBorder(new Color(0xB0C4DE))); // Light blue border
        textpan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textpan.getText().length() >= 10) {
                    e.consume(); // Ignore additional input
                }
            }
        });
        add(textpan);

        // Warning label for invalid PAN format
         JLabel panWarning = new JLabel();
        panWarning.setFont(new Font("Raleway", Font.ITALIC, 12));
        panWarning.setForeground(Color.RED);
        panWarning.setBounds(750, 480, 320, 20); // Position below the PAN text field
        add(panWarning);

        // Add a Key Listener for validation
        textpan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 pan = textpan.getText();
                if (pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
                    panWarning.setText(""); // Clear warning if valid
                } else {
                    panWarning.setText("Invalid PAN format (e.g., ABCDE1234A)");
                }
            }
        });

        JLabel l9 = new JLabel("AADHAR NUMBER:");
        l9.setFont(new Font("Raleway", Font.BOLD,19));
        l9.setBounds(500,500,190,30);
        add(l9);

        textaadhar = new JTextField();
        textaadhar.setFont(new Font("Raleway", Font.BOLD,19));
        textaadhar.setBounds(750,500,320,30);
        textaadhar.setBackground(new Color(0xF5C0B2B2, true)); // Light gray background
        textaadhar.setForeground(new Color(0x002244));
        textaadhar.setBorder(BorderFactory.createLineBorder(new Color(0xB0C4DE))); // Light blue border
        textaadhar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textaadhar.getText().length() >= 12) {
                    e.consume(); // Ignore additional input
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Allow only numeric input
                }
            }
        });
        add(textaadhar);

        JLabel l10 = new JLabel("SENIOR CITIZEN:");
        l10.setFont(new Font("Raleway", Font.BOLD,19));
        l10.setBounds(500,550,190,30);
        add(l10);

        r1=new JRadioButton("YES");
        r1.setFont(new Font("Raleway", Font.BOLD,15));
        r1.setBackground(new Color(44,117,152));
        r1.setBounds(750,550,100,30);
        add(r1);

        r2=new JRadioButton("NO");
        r2.setFont(new Font("Raleway", Font.BOLD,15));
        r2.setBackground(new Color(44,117,152));
        r2.setBounds(860,550,100,30);
        add(r2);

        ButtonGroup seniorCitizen= new ButtonGroup();
        seniorCitizen.add(r1);
        seniorCitizen.add(r2);

        JLabel l11= new JLabel("EXISTING ACCOUNT");
        l11.setFont(new Font("Raleway", Font.BOLD,19));
        l11.setBounds(500,600,190,30);
        add(l11);

        e1=new JRadioButton("YES");
        e1.setFont(new Font("Raleway", Font.BOLD,15));
        e1.setBackground(new Color(44,117,152));
        e1.setBounds(750,600,100,30);
        add(e1);

        e2=new JRadioButton("NO");
        e2.setFont(new Font("Raleway", Font.BOLD,15));
        e2.setBackground(new Color(44,117,152));
        e2.setBounds(860,600,100,30);
        add(e2);

        ButtonGroup existingAccount= new ButtonGroup();
        existingAccount.add(e1);
        existingAccount.add(e2);

        JLabel l12= new JLabel("FORM NO:");
        l12.setFont(new Font("Raleway", Font.BOLD,25));
        l12.setBounds(1250,10,125,33);
        add(l12);

        JLabel l13= new JLabel(form_no);
        l13.setFont(new Font("Raleway", Font.BOLD,25));
        l13.setBounds(1376,10,100,33);
        add(l13);

        next =new JButton("NEXT");
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBackground(new Color(44,117,152));
        next.setForeground(Color.BLACK);
        next.setBounds(980,660,100,30);
        next.addActionListener(this);
        add(next);

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        // Image bg1 = bg.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        Image bg1 = bg.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon bg2 = new ImageIcon(bg1);
        JLabel bgimage = new JLabel(bg2);
        // bgimage.setBounds(340, 145, 850, 480);
        bgimage.setBounds(0, 0, 1550, 830);
        add(bgimage);

        setLayout(null);
        //getContentPane().setBackground( new Color(222,255, 234));
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String)comboBox.getSelectedItem();
        String catgry = (String)comboBox2.getSelectedItem();
        String inc= (String)comboBox3.getSelectedItem();
        String edu = (String)comboBox4.getSelectedItem();
        String occu = (String)comboBox5.getSelectedItem();
        String pan = textpan.getText();
        String aadhar = textaadhar.getText();

        String scitizen = " ";
        if (r1.isSelected()){
            scitizen = " Yes";
        } else if (r2.isSelected()) {
            scitizen = " No";
        }
        String eaccount  = " ";
        if (e1.isSelected()){
            eaccount = " Yes";
        } else if (e2.isSelected()) {
            eaccount = " No";
        }
        try{
            if (textpan.getText().equals("") || textaadhar.getText().equals("")|| scitizen.equals(" ") || eaccount.equals(" ")){
                JOptionPane.showMessageDialog(null,"Fill All The Fields.");
            } else if ((pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) && (textaadhar.getText().length() == 12) ) {
                connection c1 =new connection();
                System.out.println("Education: " + edu);
                String q = "insert into signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, seniorCitizen, existing_Account) " +
                        "values('"+form_no+"','"+rel+"','"+catgry+"','"+inc+"','"+edu+"','"+occu+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";

                c1.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully!");
                new SignUpThree(form_no);
                setVisible(false);

            } else{
               JOptionPane.showMessageDialog(null,"Please enter the right information.");
            }

        }catch(Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
