
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class dbconnect {

    public static Connection con;
    
    public static Connection Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/franz","root","root");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}

