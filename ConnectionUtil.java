/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author oXCToo
 */
public class ConnectionUtil {
    Connection conn = null;
    PreparedStatement pata = null;
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
    /*public ArrayList<info> userinfo(String id){
        ArrayList<info> usinfo=new ArrayList<>();
        Connection conn = conDB();
        String sorgu="select * from userlogin where user_name=?";
        try {
            pata = conn.prepareStatement(sorgu);
            pata.setString(1,id);
            ResultSet rs=pata.executeQuery();
            info in;
            while(rs.next()){
                in=new info(rs.getInt("id"),
                        rs.getString("user_name"),
                        rs.getString("user_surname"),
                        rs.getString("username"),
                        rs.getString("user_password"));
                usinfo.add(in);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return usinfo;

    }*/
}
