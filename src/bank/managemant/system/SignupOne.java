package bank.managemant.system;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {
    static long random;
    JTextField nameTextField,  fnameTextField,emailTextField, addressTextField,cityTextField, pinTextField;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, married, unmarried,other, other1;
    JComboBox stateComboBox;
    SignupOne(){
        super("Application Form");
        setLayout(null);
        getContentPane().setBackground( new Color(222,255,228));
        Random ran = new Random();
        random = 1000 + ran.nextInt(9000);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel formno = new JLabel("APPLICATION FORM NO: "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(490,40,800,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetails .setBounds(584,85,400,30);
        add(personalDetails);

        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name .setBounds(400,200,100,30);
        add( name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,16));
        nameTextField.setBounds(600,200,400,30);
        nameTextField.setBorder(new LineBorder(Color.BLACK,1));
        add(nameTextField);

        JLabel fname = new JLabel("FATHER'S NAME:");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname .setBounds(400,250,200,30);
        add( fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,16));
        fnameTextField.setBounds(600,250,400,30);
        fnameTextField.setBorder(new LineBorder(Color.BLACK,1));
        add(fnameTextField);

        JLabel dob= new JLabel("DATE OF BIRTH:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(400,300,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(600,300,400,30);
        dateChooser.setForeground(Color.BLACK);

        // Get the text field inside JDateChooser
        JTextField dateField = ((JTextField) dateChooser.getDateEditor().getUiComponent());
        dateField.setBackground(Color.WHITE);
        dateField.setBorder(new LineBorder(Color.BLACK,1));
        dateField.setEditable(false); // Disable manual input

        JLabel dobErrorLabel = new JLabel(); // Label for runtime error messages
        dobErrorLabel.setFont(new Font("Raleway", Font.PLAIN, 14));
        dobErrorLabel.setForeground(Color.RED);
        dobErrorLabel.setBounds(600, 340, 400, 20);
        add(dobErrorLabel);

        dateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // If the user tries to type manually, consume the event and show an error message
                e.consume();
                dobErrorLabel.setText("Please select the date from the calendar.");
            }
        });

        dateChooser.addPropertyChangeListener("date", evt -> {
            // Clear the error message when a valid date is selected
            dobErrorLabel.setText("");
        });
        add(dateChooser);

        JLabel gender= new JLabel("GENDER:");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(400,350,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(600,350,60,30);
        male.setBackground(new Color(44,117,152));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(750,350,120,30);
        female.setBackground(new Color(44,117,152));
        add(female);

        other1 = new JRadioButton("Other");
        other1.setBounds(930,350,100,30);
        other1.setBackground(new Color(44,117,152));
        add(other1);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other1);

        JLabel email= new JLabel("EMAIL ADDRESS:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(400,400,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,16));
        emailTextField.setBounds(600,400,400,30);
        emailTextField.setBorder(new LineBorder(Color.BLACK,1));
        add(emailTextField);

        JLabel martial= new JLabel("MARITAL STATUS:");
        martial.setFont(new Font("Raleway", Font.BOLD,20));
        martial.setBounds(400,450,200,30);
        add(martial);

        married = new JRadioButton("Married");
        married.setBounds(600,450,100,30);
        married.setBackground( new Color(44,117,152));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(750,450,100,30);
        unmarried.setBackground(new Color(44,117,152));
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(930,450,100,30);
        other.setBackground(new Color(44,117,152));
        add(other);

        ButtonGroup martialgroup = new ButtonGroup();
        martialgroup.add(married);
        martialgroup.add(unmarried);
        martialgroup.add(other);

        JLabel address= new JLabel("ADDRESS:");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(400,500,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,16));
        addressTextField.setBounds(600,500,400,30);
        addressTextField.setBorder(new LineBorder(Color.BLACK,1));
        add(addressTextField);

        JLabel city= new JLabel("CITY:");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(400,550,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,16));
        cityTextField.setBounds(600,550,400,30);
        cityTextField.setBorder(new LineBorder(Color.BLACK,1));
        add(cityTextField);

        JLabel state= new JLabel("STATE:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(400,600,200,30);
        add(state);

        String[] states = {
                "Select State", "Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
                "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli and Daman and Diu", "Delhi", "Goa", "Gujarat",
                "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Ladakh",
                "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland",
                "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
                "Uttar Pradesh", "Uttarakhand", "West Bengal"
        };

        stateComboBox = new JComboBox(states);
        stateComboBox.setFont(new Font("Raleway", Font.BOLD, 16));
        stateComboBox.setBounds(600, 600, 400, 30);
        stateComboBox.setBackground(new Color(44,117,152));
        stateComboBox.setBorder(new LineBorder(Color.BLACK,1));
        add(stateComboBox);

        JLabel pincode= new JLabel("PIN CODE:");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(400,650,200,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(600,650,400,30);
        pinTextField.setBorder(new LineBorder(Color.BLACK,1));
        pinTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (pinTextField.getText().length() >= 6) {
                    e.consume(); // Ignore additional input
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Allow only numeric input
                }
            }
        });
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(920,740,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,14 ));
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

        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String form_no = " " +random;
        String name = nameTextField.getText();
        String father_name = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dob = sdf.format(dateChooser.getDate());
        } catch (Exception ex) {
         //   JOptionPane.showMessageDialog(null, "Date Of Birth Is Required.");
           // return;
            System.out.println(ex);
        }
        String gender = "";
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        } else if (other1.isSelected()) {
            gender = "Other";
        }
        String email = emailTextField.getText();
        String marital = "";
        if(married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pinTextField.getText();
        String state = (String)stateComboBox.getSelectedItem();


        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required.");
            } else if (father_name.equals("")) {
                JOptionPane.showMessageDialog(null,"Father Name is Required.");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null,"Date Of Birth is Required.");
            }else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Select Your Gender.");
            }else if (email.equals("")) {
                JOptionPane.showMessageDialog(null,"Email Is Required.");
            }else if (!email.endsWith("@gmail.com")) {
                JOptionPane.showMessageDialog(null, "Email must end with '@gmail.com'.");
            } else if (marital.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Select Your Married Status. .");
            }else if (address.equals("")) {
                JOptionPane.showMessageDialog(null,"Address Is Required.");
            }else if (city.equals("")) {
                JOptionPane.showMessageDialog(null,"City Name Is Required.");
            }else if (state.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Select Your State.");
            }else if (pincode.equals("") ) {
                JOptionPane.showMessageDialog(null,"Please Enter PinCode.");
            } else if (pinTextField.getText().length() != 6) {
                JOptionPane.showMessageDialog(null,"Please Enter valid 6-digit PinCode.");
            } else {
                connection c = new connection();
                String query = "INSERT INTO signup (form_no, name, father_name, dob, gender, email, marital, address, city, pincode, state) " +
                        "VALUES ('" + form_no + "', '" + name + "', '" + father_name + "', '" + dob + "', '" + gender + "', '" +
                        email + "', '" + marital + "', '" + address + "', '" + city + "', '" + pincode + "', '" + state + "')";
                c.s.executeUpdate(query);
                System.out.println(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully!");
                new SignUpTwo(form_no);
                setVisible(false);
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }

}