package airlinemanagementsystem;

import java.sql.*; //for Connection and Statement

/**
 *
 * @author Gurjot
 */
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn() {
        //SQL is external, there are chances of exception
        try {
            //JDBC connectivity (Java Database Connectivity)
            //Step 1: Registering the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Step 2: Create connection string (info of database to be used)
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem",
                    "root", "rootpass");
            //which connectivity - which database - where database running
            /* if default port, no need to mention the port, just add triple /
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "GuggiGill238!");*/
            //database name
            //username and password
            
            //Step 3: Create the statement from connection string
            s = c.createStatement();
            
            //Step 4: Run mySQL query
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}