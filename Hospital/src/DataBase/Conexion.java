/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

/**
 *
 * @author Shannon
 */
public class Conexion {
    Connection cn;
    Statement st;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "Shannon", "mysqlpass");
            System.out.println("Succesful conection");
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return cn;
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported");
    }
    
}
