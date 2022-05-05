package Activities;

import Data.Hospital;
import Data.Inscription;
import Data.Patient;
import DataBase.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Operations {

  Conexion con = new Conexion();
  Scanner strScanner = new Scanner(System.in);
  Scanner intScanner = new Scanner(System.in);
  Connection cn = con.conexion();
  boolean isConnected = cn != null;
  Statement st = null;
  ResultSet rs = null;
  int countrow;

  public ArrayList<Patient> getPatients() {
    ArrayList<Patient> patients = new ArrayList<Patient>();
    try {
      if (isConnected) {
        st = cn.createStatement();
        rs = st.executeQuery("select * from patients");

        while (rs.next()) {
          patients.add(new Patient(rs.getInt("id_patient"), rs.getString("name"), rs.getString("last_name"), rs.getString("age"),
                  rs.getString("gender"), rs.getDate("date_birth"), rs.getString("origin_city"), rs.getString("tutor_name"),
                  rs.getString("telephone"), rs.getString("type_blood"), rs.getBoolean("is_patient")));

          countrow++;
        }
      } else {
        patients = LocalFileOperations.ReadPatientFile();
        countrow = patients.size();
      }

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return patients;
  }

  public ArrayList<Hospital> getHospitals() {
    ArrayList<Hospital> hospitals = new ArrayList<Hospital>();

    try {
      if (isConnected) {
        st = cn.createStatement();
        rs = st.executeQuery("select * from hospitals");

        while (rs.next()) {
          hospitals.add(new Hospital(rs.getInt("id_hospital"), rs.getString("name"), rs.getString("address"), rs.getString("telephone")));
        }
      } else {
        hospitals = LocalFileOperations.ReadHospitalFile();
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());

    }
    return hospitals;
  }

  public ArrayList<Inscription> getInscriptions() {
    ArrayList<Inscription> inscriptions = new ArrayList<Inscription>();

    try {
      if (isConnected) {
        st = cn.createStatement();
        rs = st.executeQuery("select * from inscriptions");

        while (rs.next()) {
          inscriptions.add(new Inscription(rs.getInt("id_inscription"), rs.getInt("id_patient"), rs.getInt("id_hospital"), rs.getDate("date_inscription")));
        }
      } else {
        inscriptions = LocalFileOperations.ReadInscriptionFile();
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return inscriptions;
  }

  public ArrayList<Patient> getSpecificPatient(int id_patient) {
    ArrayList<Patient> patients = new ArrayList<Patient>();

    try {
      st = cn.createStatement();
      rs = st.executeQuery("select * from patients WHERE id_patient=" + id_patient);

      while (rs.next()) {
        patients.add(new Patient(rs.getInt("id_patient"), rs.getString("name"), rs.getString("last_name"), rs.getString("age"),
                rs.getString("gender"), rs.getDate("date_birth"), rs.getString("origin_city"), rs.getString("tutor_name"),
                rs.getString("telephone"), rs.getString("type_blood"), rs.getBoolean("is_patient")));

      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return patients;
  }

  public void updatePatient(int id_patient, String name, String lastname, String age, String gender, java.sql.Date dateBirth,
          String originCity, String tutorName, String telephone, String type_blood, int id_hospital) {
    try {
      PreparedStatement insert = cn.prepareCall("UPDATE Patients SET name=?,last_name=?,age=?,gender=?,date_Birth=?,origin_city=?,tutor_name=?,telephone=?, type_blood=? WHERE id_patient=?");
      insert.setString(1, name);
      insert.setString(2, lastname);
      insert.setString(3, age);
      insert.setString(4, gender);
      insert.setDate(5, dateBirth);
      insert.setString(6, originCity);
      insert.setString(7, tutorName);
      insert.setString(8, telephone);
      insert.setString(9, type_blood);
      insert.setInt(10, id_patient);
      insert.executeUpdate();

      updateInscription(id_patient, id_hospital);
      JOptionPane.showMessageDialog(null, "Succesfull update patient");
    } catch (Exception e) {
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

      JOptionPane.showMessageDialog(null, "Succesfull update Inscription");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  public void addInscription(int id_patient, int id_hospital) {
    try {
      if (isConnected) {
        PreparedStatement insert = cn.prepareCall("INSERT INTO Inscriptions(id_patient,id_hospital,date_inscription) VALUES (?,?,?)");
        insert.setInt(1, id_patient);
        insert.setInt(2, id_hospital);
        insert.setDate(3, generateDate());
        insert.executeUpdate();
      } else {
        LocalFileOperations.WriteInscriptionFile(id_patient, id_hospital);
      }

      JOptionPane.showMessageDialog(null, "Succesfull Inscription");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }

  }

  public int addPatientMysql(String name, String lastname, String age, String gender, java.sql.Date dateBirth, String originCity,
          String tutorName, String telephone, String type_blood) {
    countrow = 0;
    try {
      if (isConnected) {
        PreparedStatement insert = cn.prepareCall("INSERT INTO Patients(name,last_name,age,gender,date_Birth,origin_city,tutor_name,telephone, type_blood, is_patient)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)");
        insert.setString(1, name);
        insert.setString(2, lastname);
        insert.setString(3, age);
        insert.setString(4, gender);
        insert.setDate(5, dateBirth);
        insert.setString(6, originCity);
        insert.setString(7, tutorName);
        insert.setString(8, telephone);
        insert.setString(9, type_blood);
        insert.setBoolean(10, true);
        insert.executeUpdate();
      }
      else {
        LocalFileOperations.WritePatientlFile(name, lastname, age, gender, dateBirth, originCity, tutorName, telephone, type_blood);
      }

      JOptionPane.showMessageDialog(null, "Succesfull patient");
      getPatients();
      System.out.println(countrow);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return countrow;
  }

  public int addHospitalMysql(String name, String address, String telephone) {
    countrow = 0;
    try {
      if (isConnected) {
        PreparedStatement insert = cn.prepareCall("INSERT INTO hospitals(name,address,telephone)"
                + "VALUES (?,?,?)");
        insert.setString(1, name);
        insert.setString(2, address);
        insert.setString(3, telephone);
        insert.executeUpdate();

      } else {
        LocalFileOperations.WriteHospitalFile(name, address, telephone);
      }

      JOptionPane.showMessageDialog(null, "Succesfull hospital");
      getPatients();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return countrow;
  }

  public void deletePatient(int id_patient) {
    try {
      PreparedStatement insert = cn.prepareCall("UPDATE Patients SET is_patient=? WHERE id_patient=?");

      insert.setBoolean(1, false);
      insert.setInt(2, id_patient);
      insert.executeUpdate();

      JOptionPane.showMessageDialog(null, "Succesfull delete patient");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  public void autoIncrementUpdatePatients() {
    try {
      st = cn.createStatement();
      rs = st.executeQuery("ALTER TABLE patients  AUTO_INCREMENT = 1;");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  public void autoIncrementUpdateInscriptions() {
    try {
      st = cn.createStatement();
      rs = st.executeQuery("ALTER TABLE inscriptions  AUTO_INCREMENT = 1;");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  public java.sql.Date generateDate() {
    java.util.Date date = new java.util.Date();
    java.sql.Date sqldate = new java.sql.Date(date.getTime());

    return sqldate;
  }
}
