/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activities;

import Data.Hospital;
import Data.Inscription;
import Data.Patient;
import DataBase.Conexion;
import DataBase.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Shannon
 */
public class Operations {

    Conexion con = new Conexion();
    Connection cn = con.conexion();
    Statement st = null;
    ResultSet rs = null;

    Scanner strScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    int countrow;

    public ArrayList<Patient> getPatients() {
        ArrayList<Patient> patients = new ArrayList<Patient>();

        try {
            st = cn.createStatement();
            rs = st.executeQuery("select * from patients");

            while (rs.next()) {
                patients.add(new Patient(rs.getInt("id_patient"), rs.getString("name"), rs.getString("last_name"), rs.getInt("age"),
                        rs.getString("gender"), rs.getDate("date_birth"), rs.getString("origin_city"), rs.getString("tutor_name"),
                        rs.getString("telephone")));
                countrow++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return patients;
    }

    public ArrayList<Hospital> getHospitals() {
        ArrayList<Hospital> hospitals = new ArrayList<Hospital>();

        try {
            st = cn.createStatement();
            rs = st.executeQuery("select * from hospitals");

            while (rs.next()) {
                hospitals.add(new Hospital(rs.getInt("id_hospital"), rs.getString("name"), rs.getString("address"), rs.getString("telephone")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hospitals;
    }

    public ArrayList<Inscription> getInscriptions() {
        ArrayList<Inscription> inscriptions = new ArrayList<Inscription>();

        try {
            st = cn.createStatement();
            rs = st.executeQuery("select * from inscriptions");

            while (rs.next()) {
                inscriptions.add(new Inscription(rs.getInt("id_inscription"), rs.getInt("id_patient"), rs.getInt("id_hospital"), rs.getDate("date_inscription")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inscriptions;
    }

    public ArrayList<Patient> getSpecificPatient(int id_patient) {
        ArrayList<Patient> patients = new ArrayList<Patient>();

        try {
            st = cn.createStatement();
            rs = st.executeQuery("select * from patients WHERE id_patient=" + id_patient);

            while (rs.next()) {
                patients.add(new Patient(rs.getInt("id_patient"), rs.getString("name"), rs.getString("last_name"), rs.getInt("age"),
                        rs.getString("gender"), rs.getDate("date_birth"), rs.getString("origin_city"), rs.getString("tutor_name"),
                        rs.getString("telephone")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return patients;

    }

    public void updatePatient(int id_patient, String name, String lastname, int age, String gender, java.sql.Date dateBirth, String originCity,
            String tutorName, String telephone, int id_hospital) {

        try {
            PreparedStatement insert = cn.prepareCall("UPDATE Patients SET name=?,last_name=?,age=?,gender=?,date_Birth=?,origin_city=?,tutor_name=?,telephone=? WHERE id_patient=?");
            insert.setString(1, name);
            insert.setString(2, lastname);
            insert.setInt(3, age);
            insert.setString(4, gender);
            insert.setDate(5, dateBirth);
            insert.setString(6, originCity);
            insert.setString(7, tutorName);
            insert.setString(8, telephone);
            insert.setInt(9, id_patient);
            insert.executeUpdate();

            updateInscription(id_patient, id_hospital);

            JOptionPane.showMessageDialog(null, "Succesfull update patient");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void updateInscription(int id_patient, int id_hospital) {
        try {
            PreparedStatement insert = cn.prepareCall("UPDATE Inscriptions SET id_hospital=?,date_inscription=? WHERE id_patient=?");
            insert.setInt(1, id_hospital);
            insert.setDate(2, generateDate());
            insert.setInt(3, id_patient);
            insert.executeUpdate();

            System.out.println("Succesfull update Inscription");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addInscription(int id_patient, int id_hospital) {
        /*
         System.out.println("Origin hospital:");
         printHospitals(getHospitals());
         int id_hospital = intScanner.nextInt();
         */

        try {
            PreparedStatement insert = cn.prepareCall("INSERT INTO Inscriptions(id_patient,id_hospital,date_inscription) VALUES (?,?,?)");
            insert.setInt(1, id_patient);
            insert.setInt(2, id_hospital);
            insert.setDate(3, generateDate());
            insert.executeUpdate();

            System.out.println("Succesfull Inscription");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int addPatientMysql(String name, String lastname, int age, String gender, java.sql.Date dateBirth, String originCity,
            String tutorName, String telephone) {
        try {
            PreparedStatement insert = cn.prepareCall("INSERT INTO Patients(name,last_name,age,gender,date_Birth,origin_city,tutor_name,telephone)"
                    + "VALUES (?,?,?,?,?,?,?,?)");
            insert.setString(1, name);
            insert.setString(2, lastname);
            insert.setInt(3, age);
            insert.setString(4, gender);
            insert.setDate(5, dateBirth);
            insert.setString(6, originCity);
            insert.setString(7, tutorName);
            insert.setString(8, telephone);
            insert.executeUpdate();

            JOptionPane.showMessageDialog(null, "Succesfull patient");
            countrow = 0;
            ArrayList<Patient> patients = new ArrayList<Patient>();
            getPatients();

            System.out.println("Succesfull sending");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return countrow;
    }

    public void deletePatient(int id_patient) {
        try {
            PreparedStatement insert = cn.prepareCall("DELETE from Patients WHERE id_patient=?");
            insert.setInt(1, id_patient);
            insert.executeUpdate();

            JOptionPane.showMessageDialog(null, "Succesfull delete patient");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void autoIncrementUpdatePatients() {

        try {
            st = cn.createStatement();
            rs = st.executeQuery("ALTER TABLE patients  AUTO_INCREMENT = 1;");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void autoIncrementUpdateInscriptions() {

        try {
            st = cn.createStatement();
            rs = st.executeQuery("ALTER TABLE inscriptions  AUTO_INCREMENT = 1;");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void addPatient() {

        System.out.println("name:");
        String name = strScanner.nextLine();
        System.out.println("last name: ");
        String last_name = strScanner.nextLine();

        System.out.println("age: ");
        int age = intScanner.nextInt();
        System.out.println("gender: ");
        String gender = strScanner.nextLine();
        System.out.println("Date birth:");
        System.out.println("Date: ");
        int date = intScanner.nextInt();
        System.out.println("Month: ");
        int month = intScanner.nextInt();
        System.out.println("Year: ");
        int year = intScanner.nextInt();
        System.out.println("origin city: ");
        String originCity = strScanner.nextLine();
        System.out.println("tutor name: ");
        String tutorName = strScanner.nextLine();
        System.out.println("telephone: ");
        int telephone = intScanner.nextInt();

        // addPatientMysql(name, last_name, age, gender, generateDateBirth(date, month, year), originCity, tutorName, telephone);
    }

    public void printHospitals(ArrayList<Hospital> hospitals) {

        for (int t = 0; t < hospitals.size(); t++) {
            System.out.println(hospitals.get(t).getId_hospital() + " " + hospitals.get(t).getName() + " " + hospitals.get(t).getAddress() + " " + hospitals.get(t).getTelephone());
        }
    }

    public void printPatients(ArrayList<Patient> patients) {

        for (int t = 0; t < patients.size(); t++) {
            System.out.println(patients.get(t).getId_patient() + " " + patients.get(t).getName() + " " + patients.get(t).getLastname() + " " + patients.get(t).getDateBirth());
        }
    }

    public void menu() {
        System.out.println("\n 1.Patient register \n 2.Edit patient register \n 3.Query patients \n 4.Delete patient");
    }

    public java.sql.Date generateDate() {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        return sqldate;
    }

    public java.sql.Date generateDateBirth(int date, int month, int year) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DATE, date);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);

        Date dateone = calendar.getTime();

        java.sql.Date sqldate = new java.sql.Date(dateone.getTime());

        return sqldate;
    }

    public boolean isNumeric(String number) {
        return number.matches("[0-9]*");
    }

    public boolean isLetter(String words) {
        for (int x = 0; x < words.length(); x++) {
            char c = words.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

}
