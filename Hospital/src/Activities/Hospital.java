/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activities;

import Data.Patient;
import DataBase.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Shannon
 */
public class Hospital {

    public Hospital() {
        Operations activities = new Operations();

        activities.menu();
        activities.printPatients(activities.getPatients());
    }

    public static void main(String[] args) {
        new Hospital();
    }

}
