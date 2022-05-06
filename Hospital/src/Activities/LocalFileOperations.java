/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activities;

import Data.Hospital;
import Data.Inscription;
import Data.Patient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalFileOperations {

  private static File patientFile = new File("src/DataBase/PatientData.csv");
  private static File hospitalFile = new File("src/DataBase/HospitalData.csv");
  private static File inscriptionFile = new File("src/DataBase/InscriptionData.csv");

  public static ArrayList<Patient> ReadPatientFile() {
    FileReader reader;
    ArrayList<Patient> patients = new ArrayList<>();
    try {
      reader = new FileReader(patientFile);
      String line = "";
      BufferedReader buffer = new BufferedReader(reader);
      buffer.readLine();
      while ((line = buffer.readLine()) != null) {
        String[] values = line.split(",");
        patients.add(new Patient(Integer.parseInt(values[0]), values[1], values[2],
                values[3], values[4], new java.sql.Date(getDateSQL(values[5]).getTime()), values[6], values[7], values[8], values[9], values[10].contains("1") ? true : false));
      }
      return patients;
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public static ArrayList<Patient> ReadSpecificPatientFile(int id_patient) {
    FileReader reader;
    ArrayList<Patient> patients = new ArrayList<>();
    try {
      reader = new FileReader(patientFile);
      String line = "";
      BufferedReader buffer = new BufferedReader(reader);
      buffer.readLine();
      while ((line = buffer.readLine()) != null) {
        String[] values = line.split(",");
        if (Integer.parseInt(values[0]) == id_patient) {
          patients.add(new Patient(Integer.parseInt(values[0]), values[1], values[2],
                  values[3], values[4], new java.sql.Date(getDateSQL(values[5]).getTime()), values[6], values[7], values[8], values[9], values[10].contains("1") ? true : false));
        }
      }
      return patients;
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public static ArrayList<Hospital> ReadHospitalFile() {
    FileReader reader;
    ArrayList<Hospital> hospitals = new ArrayList<>();
    try {
      reader = new FileReader(hospitalFile);
      String line = "";
      BufferedReader buffer = new BufferedReader(reader);
      buffer.readLine();
      while ((line = buffer.readLine()) != null) {
        String[] values = line.split(",");
        hospitals.add(new Hospital(Integer.parseInt(values[0]), values[1], values[2], values[3]));
      }
      return hospitals;
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    }
    return null;
  }

  public static ArrayList<Inscription> ReadInscriptionFile() {
    FileReader reader;
    ArrayList<Inscription> inscriptions = new ArrayList<>();
    try {
      reader = new FileReader(inscriptionFile);
      String line = "";
      BufferedReader buffer = new BufferedReader(reader);
      buffer.readLine();
      while ((line = buffer.readLine()) != null) {
        String[] values = line.split(",");
        inscriptions.add(new Inscription(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                Integer.parseInt(values[2]), new java.sql.Date(getDateSQL(values[3]).getTime())));
      }
      return inscriptions;
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public static void WritePatientlFile(String name, String lastname, String age, String gender, java.sql.Date dateBirth, String originCity,
          String tutorName, String telephone, String type_blood) {
    FileWriter writer;
    try {
      ArrayList<Patient> patients = ReadPatientFile();
      writer = new FileWriter(patientFile, true);
      int id = patients.get(patients.size() - 1).getId_patient() + 1;
      String row = generatePatientRow(id, name, lastname, age, gender, dateBirth, originCity, tutorName, telephone, type_blood, true, 0);
      writer.append(row);
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void WriteHospitalFile(String name, String address, String telephone) {
    FileWriter writer;
    try {
      ArrayList<Hospital> hospitals = ReadHospitalFile();
      writer = new FileWriter(hospitalFile, true);
      StringBuilder lines = new StringBuilder();
      lines.append(hospitals.get(hospitals.size() - 1).getId_hospital() + 1);
      lines.append(",");
      lines.append(name);
      lines.append(",");
      lines.append(address);
      lines.append(",");
      lines.append(telephone);
      lines.append(",");
      lines.append(0);
      lines.append("\n");
      writer.append(lines.toString());
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    }
  }

  public static void WriteSinchronizeHospitalsFile(ArrayList<Hospital> hospitals) {
    FileWriter writer;
    try {
      new FileWriter(hospitalFile, false).close();
      writer = new FileWriter(hospitalFile, true);
      writer.append("id_hospital,name,address,telephone,is_sinchronized\n");
      for (Hospital hospital : hospitals) {
        String row = generateSHospitaltRow(hospital.getId_hospital(), hospital.getName(),
                hospital.getAddress(), hospital.getTelephone());
        writer.append(row);
      }
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void UpdatePatientFile(int id_patient, String name, String lastname, String age, String gender, java.sql.Date dateBirth, String originCity,
          String tutorName, String telephone, String type_blood) {
    FileWriter writer;
    try {
      ArrayList<Patient> patients = ReadPatientFile();
      new FileWriter(patientFile, false).close();
      writer = new FileWriter(patientFile, true);
      writer.append("﻿Id_patient,name,last_name,age,gender,date_birth,origin_city,tutor_name,telephone,type_blood,is_patient,is_synchronized\n");
      for (Patient patient : patients) {
        if (patient.getId_patient() == id_patient) {
          patient.setName(name);
          patient.setLastname(lastname);
          patient.setAge(age);
          patient.setGender(gender);
          patient.setDateBirth(dateBirth);
          patient.setOriginCity(originCity);
          patient.setTutorName(tutorName);
          patient.setTelephone(telephone);
          patient.setTypeBlood(type_blood);
        }
        String row = generatePatientRow(patient.getId_patient(), patient.getName(), patient.getLastname(), patient.getAge(),
                patient.getGender(), patient.getDateBirth(), patient.getOriginCity(), patient.getTutorName(), patient.getTelephone(),
                patient.getTypeBlood(), true, 0);
        writer.append(row);
      }
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void WriteInscriptionFile(int id_patient, int id_hospital) {
    FileWriter writer;
    try {
      ArrayList<Inscription> inscriptions = ReadInscriptionFile();
      writer = new FileWriter(inscriptionFile, true);
      StringBuilder lines = new StringBuilder();
      lines.append(inscriptions.get(inscriptions.size() - 1).getId_inscription() + 1);
      lines.append(",");
      lines.append(id_patient);
      lines.append(",");
      lines.append(id_hospital);
      lines.append(",");
      lines.append(getDateSQL());
      lines.append("\n");
      writer.append(lines.toString());
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void UpdateInscriptionFile(int id_patient, int id_hospital) {
    FileWriter writer;
    try {
      ArrayList<Inscription> inscriptions = ReadInscriptionFile();
      new FileWriter(inscriptionFile, false).close();
      writer = new FileWriter(inscriptionFile, true);
      writer.append("﻿id_inscription,id_patient,id_hospital,date_inscription\n");
      for (Inscription inscription : inscriptions) {
        StringBuilder lines = new StringBuilder();
        lines.append(inscription.getId_inscription());
        lines.append(",");
        lines.append(inscription.getId_patient());
        lines.append(",");
        if (inscription.getId_patient() == id_patient) {
          lines.append(id_hospital);
        } else {
          lines.append(inscription.getId_hospital());
        }
        lines.append(",");
        lines.append(getDateSQL(inscription.getDate_inscription()));
        lines.append("\n");
        writer.append(lines.toString());
      }
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void deletePatientFile(int id_patient) {
    FileWriter writer;
    try {
      ArrayList<Patient> patients = ReadPatientFile();
      new FileWriter(patientFile, false).close();
      writer = new FileWriter(patientFile, true);
      writer.append("﻿Id_patient,name,last_name,age,gender,date_birth,origin_city,tutor_name,telephone,type_blood,is_patient\n");
      for (Patient patient : patients) {
        if (patient.getId_patient() == id_patient) {
          patient.setIs_patient(false);
        }
        String row = generatePatientRow(patient.getId_patient(), patient.getName(), patient.getLastname(), patient.getAge(),
                patient.getGender(), patient.getDateBirth(), patient.getOriginCity(), patient.getTutorName(), patient.getTelephone(),
                patient.getTypeBlood(), patient.getIs_patient(), 0);
        writer.append(row);
      }
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static ArrayList<Hospital> ReadDesinchronizedHospitalsFile() {
    FileReader reader;
    ArrayList<Hospital> hospitals = new ArrayList<>();
    try {
      reader = new FileReader(hospitalFile);
      String line = "";
      BufferedReader buffer = new BufferedReader(reader);
      buffer.readLine();
      while ((line = buffer.readLine()) != null) {
        String[] values = line.split(",");
        System.out.println("values: " + values[4]);
        if (Integer.parseInt(values[4]) == 0) {
          hospitals.add(new Hospital(Integer.parseInt(values[0]), values[1], values[2], values[3]));
        }
      }
      return hospitals;
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    }
    return null;
  }

  public static ArrayList<Patient> ReadDesinchronizedPatientFile() {
    FileReader reader;
    ArrayList<Patient> patients = new ArrayList<>();
    try {
      reader = new FileReader(patientFile);
      String line = "";
      BufferedReader buffer = new BufferedReader(reader);
      buffer.readLine();
      while ((line = buffer.readLine()) != null) {
        String[] values = line.split(",");
        if (Integer.parseInt(values[11]) == 0) {
          patients.add(new Patient(Integer.parseInt(values[0]), values[1], values[2],
                  values[3], values[4], new java.sql.Date(getDateSQL(values[5]).getTime()),
                  values[6], values[7], values[8], values[9], values[10].contains("1") ? true : false));

        }
      }
      return patients;
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public static void WriteSinchronizePatientsFile(ArrayList<Patient> patients) {
    FileWriter writer;
    try {
      new FileWriter(patientFile, false).close();
      writer = new FileWriter(patientFile, true);
      writer.append("id_hospital,name,address,telephone,is_sinchronized\n");
      for (Patient patient : patients) {
        String row = generatePatientRow(patient.getId_patient(), patient.getName(), patient.getLastname(), 
          patient.getAge(), patient.getGender(), patient.getDateBirth(), patient.getOriginCity(), 
          patient.getTutorName(), patient.getTelephone(), patient.getTypeBlood(), patient.getIs_patient(), 1);
        writer.append(row);
      }
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Excepcion de archivo");
    } catch (IOException e) {
      System.out.println("Excepcion no identificada");
    } catch (ParseException ex) {
      Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static Date getDateSQL(String date) throws ParseException {
    date = date.replaceAll("-", "/");
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Date parsed = format.parse(date);
    return parsed;
  }

  private static String getDateSQL() throws ParseException {
    Date stayDate = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    return format.format(new java.sql.Date(stayDate.getTime()));
  }

  private static String getDateSQL(java.sql.Date date) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    return format.format(date);
  }

  private static String generatePatientRow(int id_patient, String name, String lastname, String age, String gender, java.sql.Date dateBirth, String originCity,
          String tutorName, String telephone, String type_blood, boolean isPatient, int isSincro) throws ParseException {
    StringBuilder lines = new StringBuilder();
    lines.append(id_patient);
    lines.append(",");
    lines.append(name);
    lines.append(",");
    lines.append(lastname);
    lines.append(",");
    lines.append(age);
    lines.append(",");
    lines.append(gender);
    lines.append(",");
    lines.append(getDateSQL(dateBirth));
    lines.append(",");
    lines.append(originCity);
    lines.append(",");
    lines.append(tutorName);
    lines.append(",");
    lines.append(telephone);
    lines.append(",");
    lines.append(type_blood);
    lines.append(",");
    lines.append(isPatient ? 1 : 0);
    lines.append(",");
    lines.append(isSincro);
    lines.append("\n");
    return lines.toString();
  }

  private static String generateSHospitaltRow(int id_hospital, String name, String address, String telephone) throws ParseException {
    StringBuilder lines = new StringBuilder();
    lines.append(id_hospital);
    lines.append(",");
    lines.append(name);
    lines.append(",");
    lines.append(address);
    lines.append(",");
    lines.append(telephone);
    lines.append(",");
    lines.append(1);
    lines.append("\n");
    return lines.toString();
  }
}
