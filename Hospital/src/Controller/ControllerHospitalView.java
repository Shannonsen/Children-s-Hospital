package Controller;

import View.HospitalView;
import Activities.Operations;
import Data.Hospital;
import Data.Inscription;
import Data.Patient;
import Exceptions.EmptyFieldException;
import Exceptions.InvalidDateException;
import Exceptions.InvalidLengthTelephoneException;
import Exceptions.ManagerException;
import Exceptions.NotAllowedCharacterException;
import View.AddHospitalView;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        String[] typebloods = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
        hospital.getCombTypeBlood().setModel(new DefaultComboBoxModel(typebloods));
        for (int i = 0; i < hospitals.size(); i++) {
            hospital.getCombHospital().addItem(hospitals.get(i).getName());
        }
        TableChildren();
    }

    private void initComponents() {
        hospital.getBtnAddPatient().addActionListener(this::addPatient);
        hospital.getBtnModifyPatient().addActionListener(this::modifyPatient);
        hospital.getBtnAddHospital().addActionListener(this::addHospital);
        hospital.getTbChildren().addMouseListener(tbClick);
        hospital.getBtnDeletePatient().addActionListener(this::deletePatient);
    }

    private void addPatient(ActionEvent e) {
        try {
            ManagerException.EmptyField(hospital.getTxtName().getText(), "Name");
            ManagerException.EmptyField(hospital.getTxtLastName().getText(), "Last Name");
            ManagerException.EmptyField(hospital.getTxtOriginCity().getText(), "City");
            ManagerException.DateValidation(hospital.getDateChooser().getDate(), "Date birth");
            ManagerException.EmptyField(hospital.getTxtTutor().getText(), "Tutor");
            ManagerException.TelephoneNumberValidation(hospital.getTxtTelephone().getText());
        } catch (EmptyFieldException | InvalidDateException | NotAllowedCharacterException | InvalidLengthTelephoneException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
        String name = hospital.getTxtName().getText();
        String lastName = hospital.getTxtLastName().getText();
        String gender = (String) hospital.getCombGender().getSelectedItem();

        java.util.Date date = hospital.getDateChooser().getDate();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        LocalDate lclDate = LocalDate.parse(sqldate.toString());
        int age = calculateAge(lclDate);

        java.sql.Date dateBirth = sqldate;
        String originCity = hospital.getTxtOriginCity().getText();
        String tutorName = hospital.getTxtTutor().getText();
        String telephone = hospital.getTxtTelephone().getText();
        String typeBlood = (String) hospital.getCombTypeBlood().getSelectedItem();
        String originHospital = (String) hospital.getCombHospital().getSelectedItem();

        int id_hospital = 1;
        for (int i = 0; i < hospitals.size(); i++) {
            if (originHospital.equals(hospitals.get(i).getName())) {
                id_hospital = hospitals.get(i).getId_hospital();
            }
        }

        int rowcount = activities.addPatientMysql(name, lastName, Integer.toString(age), gender, dateBirth, originCity, tutorName, telephone, typeBlood);

        TableChildren();
        activities.addInscription(patients.get(rowcount - 1).getId_patient(), id_hospital);
        System.out.println("after that");
        TableChildren();
        cleanData();

    }

    public static int calculateAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        if ((dob != null) && (curDate != null)) {
            return Period.between(dob, curDate).getYears();
        } else {
            return 0;
        }
    }

    public void modifyPatient(ActionEvent e) {
        try {
            ManagerException.EmptyField(hospital.getTxtName().getText(), "Name");
            ManagerException.EmptyField(hospital.getTxtLastName().getText(), "Name");
            ManagerException.EmptyField(hospital.getTxtOriginCity().getText(), "City");
            ManagerException.DateValidation(hospital.getDateChooser().getDate(), "Date birth");
            ManagerException.EmptyField(hospital.getTxtTutor().getText(), "Tutor");
            ManagerException.TelephoneNumberValidation(hospital.getTxtTelephone().getText());
        } catch (EmptyFieldException | InvalidDateException | NotAllowedCharacterException | InvalidLengthTelephoneException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
        if (currentId == 0) {
            JOptionPane.showMessageDialog(null, "Select a patient");
        } else {
            String name = hospital.getTxtName().getText();
            String lastName = hospital.getTxtLastName().getText();
            String gender = (String) hospital.getCombGender().getSelectedItem();

            java.util.Date date = hospital.getDateChooser().getDate();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            java.sql.Date dateBirth = sqldate;

            LocalDate lclDate = LocalDate.parse(sqldate.toString());
            int age = calculateAge(lclDate);

            String originCity = hospital.getTxtOriginCity().getText();
            String tutorName = hospital.getTxtTutor().getText();
            String telephone = hospital.getTxtTelephone().getText();
            String typeBlood = (String) hospital.getCombTypeBlood().getSelectedItem();
            String originHospital = (String) hospital.getCombHospital().getSelectedItem();

            int id_hospital = 0;
            for (int j = 0; j < hospitals.size(); j++) {
                if (hospitals.get(j).getName().equals(originHospital)) {
                    id_hospital = hospitals.get(j).getId_hospital();
                }
            }

            activities.updatePatient(currentId, name, lastName, Integer.toString(age), gender, dateBirth, originCity, tutorName, telephone, typeBlood, id_hospital);
            TableChildren();
            cleanData();
            currentId = 0;

        }
    }

    public void deletePatient(ActionEvent e) {
        if (currentId == 0) {
            JOptionPane.showMessageDialog(null, "Select a patient");
        } else {
            activities.deletePatient(currentId);
            TableChildren();
            cleanData();
            currentId = 0;
        }
    }

    public void addHospital(ActionEvent e) {
        AddHospitalView addHospitalview = new AddHospitalView();
        addHospitalview.setLocationRelativeTo(null);
        addHospitalview.setVisible(true);
        new ControllerAddHospitalView(addHospitalview);
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
                hospital.getTxtTutor().setText(patient.get(i).getTutorName());
                hospital.getTxtTelephone().setText(patient.get(i).getTelephone());
                hospital.getCombGender().setSelectedItem(patient.get(i).getGender());
                hospital.getDateChooser().setDate(patient.get(i).getDateBirth());
                hospital.getCombTypeBlood().setSelectedItem(patient.get(i).getTypeBlood());

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

        Object rowData[] = new Object[12];
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getIs_patient()) {
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
                rowData[11] = patients.get(i).getTypeBlood();
                tableChildren.addRow(rowData);
            }
        }
    }

    public void cleanData() {
        hospital.getTxtName().setText("");
        hospital.getTxtLastName().setText("");
        hospital.getTxtOriginCity().setText("");
        hospital.getTxtTutor().setText("");
        hospital.getTxtTelephone().setText("");
    }

}
