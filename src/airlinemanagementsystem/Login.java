package airlinemanagementsystem;

import javax.swing.*; //for JFrame, JLabel
import java.awt.*; //for Color
import java.awt.event.*;  //for ActionListener
import java.sql.*;

/**
 *
 * @author Gurjot
 */
public class Login extends JFrame implements ActionListener {
    
    //all classes whose name starts with a J are Swing classes.

    JButton reset, submit, close;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); //not to use the default layout
        //layouts: border, card, grid, flow, grid-Bag, group, spring layout
        //default: border layout
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20); //left, top, length, height
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20); //left, top, length, height
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);
        
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400,250); //horizontal x, vertical y
        setLocation(600,250); //distance from left, top (by default left corner)
        setVisible(true); //to see the frames
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            //getText is deprecated
            //alt: getPassword(), but it returns an array of characters
            
            //open connection with database
            try{
                Conn c = new Conn();
                
                String query = "select * from login where username='" + username + "' and password ='" + password+"'";
                ResultSet rs = c.s.executeQuery(query);
                //for DDL commands: executeQuery()
                //for DML commands: executeUpdate()
                
                if(rs.next()) {
                    new Home();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid username or Password");
                    setVisible(false);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == close){
            setVisible(false);
        }
        else if(ae.getSource() == reset){
            tfusername.setText("");
            tfpassword.setText("");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
    
}