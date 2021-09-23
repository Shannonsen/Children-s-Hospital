/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activities;

import Data.Patient;
import DataBase.Conexion;
import DataBase.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Shannon
 */
public class Operations {

    Conexion con = new Conexion();
    Connection cn = con.conexion();
    Statement st;
    ResultSet rs;

    public ArrayList<Patient> getPatients() {
        ArrayList<Patient> patients = new ArrayList<Patient>();

        try {
            st = cn.createStatement();
            rs = st.executeQuery("select * from patients");

            while (rs.next()) {
                patients.add(new Patient(rs.getString("name"), rs.getString("last name"), rs.getInt("age"),
                        rs.getString("gender"), rs.getDate("date_birth"), rs.getString("origin_city"), rs.getString("tutor_name"),
                        rs.getInt("telephone")));
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return patients;
    }

    public void printPatients(ArrayList<Patient> patients) {

        for (int t = 0; t < patients.size(); t++) {
            System.out.println(patients.get(t).getName() + " " + patients.get(t).getLastname() + " " + patients.get(t).getDateBirth());
        }
    }

    public void menu() {
        System.out.println("\n 1.Patient register \n 2.Edit patient register \n 3.Query patients \n 4.Delete patient");
    }

}
