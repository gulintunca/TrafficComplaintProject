/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oXCToo
 */
public class ConnectionUtil {
    Connection conn = null;
    public static Connection conDB()
    {
        String dbName="traffic";
        String userName="root";
        String password="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
            return null;
        }
    }
    //make sure you add the lib
}
