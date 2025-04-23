package bank.managemant.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
    Connection c;
    Statement s;

    public connection(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm_db","your_username","your_password");
            // NOTE: Use your actual MySQL credentials when running locally.
            s  = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
