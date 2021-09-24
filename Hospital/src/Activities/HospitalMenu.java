/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activities;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Shannon
 */
public class HospitalMenu {

    public HospitalMenu() throws SQLException {
        Operations activities = new Operations();
        Scanner strScanner = new Scanner(System.in);
        activities.printHospitals(activities.getHospitals());
        
        activities.printPatients(activities.getPatients());
        
        activities.menu();
        int respuesta = strScanner.nextInt();

        switch (respuesta) {
            case 1:
                activities.addPatient();
                break;
            case 2:
                System.out.println("");
                break;
            case 3:
               activities.printPatients(activities.getPatients()); 
                break;
            case 4:
                System.out.println("");
                break;
        }

        activities.cn.close();
    }

    public static void main(String[] args) throws SQLException {
        new HospitalMenu();
    }

}
