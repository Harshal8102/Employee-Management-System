/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.sql.*;
public class Conn {
    Connection con;
    Statement s;
    public Conn(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/EmployeeManagementSystem";
            
            con = DriverManager.getConnection(url,"root","Hsm@8102");
            
            s=con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
