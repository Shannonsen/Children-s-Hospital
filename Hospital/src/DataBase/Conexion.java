package DataBase;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "Succesful conection");
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return cn;
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported");
    }

}
