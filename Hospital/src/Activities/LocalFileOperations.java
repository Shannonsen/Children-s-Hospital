/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Activities;

import Data.Patient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalFileOperations {

private static File database = new File("src/DataBase/PatientData.csv");

  public static ArrayList<Patient> ReadFile(){
        FileReader reader;
        ArrayList<Patient> students = new ArrayList<>();
        try {
            reader = new FileReader(database);
            String line = "";
            BufferedReader buffer = new BufferedReader(reader);
            buffer.readLine();
            while ((line = buffer.readLine()) != null) {
                String[] values = line.split(",");
              System.out.println(values[5]);
                students.add(new Patient(Integer.parseInt(values[0]),values[1], values[2], 
                  values[3], values[4], new java.sql.Date(getDateSQL(values[5]).getTime()), values[6], values[7], values[8], values[9]));
            }
            return students;
        } catch (FileNotFoundException e) {
            System.out.println("Excepcion de archivo");
        } catch (IOException e) {
            System.out.println("Excepcion no identificada");
        } catch (ParseException ex) {
    Logger.getLogger(LocalFileOperations.class.getName()).log(Level.SEVERE, null, ex);
  }
        return null;
    }

    private static Date getDateSQL(String date) throws ParseException{
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      Date parsed = format.parse(date);
      return parsed;
    }
}
