package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Gurjot
 */
public class FlightInfo extends JFrame {
    public FlightInfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table = new JTable();
        
        try {
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //if we don't want to use a JAR file,
            /*
            create a 2D array [row][column]
            row = 0, column = 0
            for(rows){
                for(columns) {
                    arr[row][column] = data
                    column++
                }
                row++
            }
            */
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 800, 500);
        add(jsp);
        
        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FlightInfo();
    }
}