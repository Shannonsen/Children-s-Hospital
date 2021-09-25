/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Activities.HospitalView;
import Activities.Operations;
import Data.Hospital;
import Data.Inscription;
import Data.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shannon
 */
public class ControllerHospitalView {

    private final HospitalView hospital;
    Operations activities = new Operations();
    ArrayList<Patient> patients = activities.getPatients();
    ArrayList<Inscription> inscriptions = activities.getInscriptions();
    ArrayList<Hospital> hospitals = activities.getHospitals();
    int currentId;

    public ControllerHospitalView(HospitalView hospital) {
        this.hospital = hospital;
        initComponents();
        hospital.getCombGender().addItem("F");
        hospital.getCombGender().addItem("M");
        for (int i = 0; i < hospitals.size(); i++) {
            hospital.getCombHospital().addItem(hospitals.get(i).getName());
        }
        TableChildren();
    }

    private void initComponents() {
        hospital.getBtnAddPatient().addActionListener(this::addPatient);
        hospital.getBtnModifyPatient().addActionListener(this::modifyPatient);
        hospital.getTbChildren().addMouseListener(tbClick);
        hospital.getBtnDeletePatient().addActionListener(this::deletePatient);
    }

    private void addPatient(ActionEvent e) {

        for (int i = 0; i < inscriptions.size(); i++) {
            System.out.println(inscriptions.get(i).getId_inscription() + " " + inscriptions.get(i).getId_patient() + " " + inscriptions.get(i).getId_hospital());
        }

        String name = hospital.getTxtName().getText();
        String lastName = hospital.getTxtLastName().getText();
        int age = Integer.parseInt(hospital.getTxtAge().getText());
        String gender = (String) hospital.getCombGender().getSelectedItem();

        java.util.Date date = hospital.getDateChooser().getDate();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        java.sql.Date dateBirth = sqldate;
        String originCity = hospital.getTxtOriginCity().getText();
        String tutorName = hospital.getTxtTutor().getText();
        String telephone = hospital.getTxtTelephone().getText();
        String originHospital = (String) hospital.getCombHospital().getSelectedItem();

        boolean isNumeric = false;
        boolean isLetterName = false;
        boolean isLetterLastName = false;
        boolean isLetterTutorName = false;

        isLetterName = activities.isLetter(name);
        System.out.println(isLetterName);
        isLetterLastName = activities.isLetter(lastName);
        System.out.println(isLetterLastName);
        isLetterTutorName = activities.isLetter(tutorName);
        System.out.println(isLetterTutorName);

        isNumeric = activities.isNumericTelephone(telephone);

        if (isNumeric == false) {
            JOptionPane.showMessageDialog(null, "Only numbers or 9-10 numbers necessary");
        } else if (isLetterName == false || isLetterLastName == false || isLetterTutorName == false) {
            JOptionPane.showMessageDialog(null, "Only letters");
        } else {

            int id_hospital = 1;
            for (int i = 0; i < hospitals.size(); i++) {
                if (originHospital.equals(hospitals.get(i).getName())) {
                    id_hospital = hospitals.get(i).getId_hospital();
                }
            }

            int rowcount = activities.addPatientMysql(name, lastName, age, gender, dateBirth, originCity, tutorName, telephone);
            TableChildren();
            activities.addInscription(patients.get(rowcount - 1).getId_patient(), id_hospital);
            TableChildren();
            cleanData();
        }

    }

    public void modifyPatient(ActionEvent e) {
        String name = hospital.getTxtName().getText();
        String lastName = hospital.getTxtLastName().getText();
        int age = Integer.parseInt(hospital.getTxtAge().getText().trim());
        String gender = (String) hospital.getCombGender().getSelectedItem();
        //java.sql.Date dateBirth = activities.generateDate();

        java.util.Date date = hospital.getDateChooser().getDate();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());

        java.sql.Date dateBirth = sqldate;

        String originCity = hospital.getTxtOriginCity().getText();
        String tutorName = hospital.getTxtTutor().getText();
        String telephone = hospital.getTxtTelephone().getText();
        String originHospital = (String) hospital.getCombHospital().getSelectedItem();
        boolean isNumeric = false;
        boolean isLetterName = false;
        boolean isLetterLastName = false;
        boolean isLetterTutorName = false;

        isLetterName = activities.isLetter(name);
        System.out.println(isLetterName);
        isLetterLastName = activities.isLetter(lastName);
        System.out.println(isLetterLastName);
        isLetterTutorName = activities.isLetter(tutorName);
        System.out.println(isLetterTutorName);

        isNumeric = activities.isNumericTelephone(telephone);

        if (isNumeric == false) {
            JOptionPane.showMessageDialog(null, "Only numbers or 9-10 numbers necessary");
        } else if (isLetterName == false || isLetterLastName == false || isLetterTutorName == false) {
            JOptionPane.showMessageDialog(null, "Only letters");
        } else {
            int id_hospital = 0;
            for (int j = 0; j < hospitals.size(); j++) {
                if (hospitals.get(j).getName().equals(originHospital)) {
                    System.out.println(hospitals.get(j).getName() + " = " + originHospital);
                    id_hospital = hospitals.get(j).getId_hospital();
                }
            }

            activities.updatePatient(currentId, name, lastName, age, gender, dateBirth, originCity, tutorName, telephone, id_hospital);

            TableChildren();
            cleanData();
        }
    }

    public void deletePatient(ActionEvent e) {
        activities.deletePatient(currentId);
        TableChildren();
        cleanData();
    }

    MouseListener tbClick = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            int selectRow = hospital.getTbChildren().getSelectedRow();
            int id = Integer.parseInt(hospital.getTbChildren().getValueAt(selectRow, 0).toString());
            currentId = id;
            ArrayList<Patient> patient = new ArrayList<Patient>();
            patient = activities.getSpecificPatient(id);

            for (int i = 0; i < patient.size(); i++) {
                hospital.getTxtName().setText(patient.get(i).getName());
                hospital.getTxtLastName().setText(patient.get(i).getLastname());
                hospital.getTxtOriginCity().setText(patient.get(i).getOriginCity());
                hospital.getTxtAge().setText(String.valueOf(patient.get(i).getAge()));
                hospital.getTxtTutor().setText(patient.get(i).getTutorName());
                hospital.getTxtTelephone().setText(patient.get(i).getTelephone());
                hospital.getCombGender().setSelectedItem(patient.get(i).getGender());
                hospital.getDateChooser().setDate(patient.get(i).getDateBirth());

                for (int j = 0; j < inscriptions.size(); j++) {
                    if (id == inscriptions.get(j).getId_patient()) {
                        for (int n = 0; n < hospitals.size(); n++) {
                            if (inscriptions.get(j).getId_hospital() == hospitals.get(n).getId_hospital()) {
                                hospital.getCombHospital().setSelectedItem(hospitals.get(n).getName());
                            }
                        }
                    }
                }

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    };

    public void TableChildren() {

        patients = activities.getPatients();
        inscriptions = activities.getInscriptions();
        hospitals = activities.getHospitals();

        DefaultTableModel tableChildren = (DefaultTableModel) hospital.getTbChildren().getModel();
        tableChildren.setRowCount(0);

        Object rowData[] = new Object[11];

        for (int i = 0; i < patients.size(); i++) {
            rowData[0] = patients.get(i).getId_patient();
            rowData[1] = patients.get(i).getName();
            rowData[2] = patients.get(i).getLastname();
            rowData[3] = patients.get(i).getAge();
            rowData[4] = patients.get(i).getGender();

            for (int j = 0; j < inscriptions.size(); j++) {
                if (inscriptions.get(j).getId_patient() == patients.get(i).getId_patient()) {
                    rowData[6] = inscriptions.get(j).getDate_inscription();

                    for (int n = 0; n < hospitals.size(); n++) {
                        if (inscriptions.get(j).getId_hospital() == hospitals.get(n).getId_hospital()) {
                            rowData[5] = hospitals.get(n).getName();
                        }
                    }
                }
            }

            rowData[7] = patients.get(i).getDateBirth();
            rowData[8] = patients.get(i).getTutorName();
            rowData[9] = patients.get(i).getTelephone();
            rowData[10] = patients.get(i).getOriginCity();
            tableChildren.addRow(rowData);
        }
    }

    public void cleanData() {
        hospital.getTxtName().setText("");
        hospital.getTxtLastName().setText("");
        hospital.getTxtOriginCity().setText("");
        hospital.getTxtAge().setText("");
        hospital.getTxtTutor().setText("");
        hospital.getTxtTelephone().setText("");
    }

}
