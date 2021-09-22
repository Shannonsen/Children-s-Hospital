/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activities;

import DataBase.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author Shannon
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion con = new Conexion();
        Connection cn = con.conexion();
        Statement st;
        ResultSet rs;

        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select * from hospital");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            st.close();
        } catch (Exception e) {

        }      
       
    }  
    
}
