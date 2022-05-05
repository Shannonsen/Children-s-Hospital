package Controller;

import Activities.Operations;
import Data.Hospital;
import Data.Inscription;
import Data.Patient;
import Exceptions.EmptyFieldException;
import Exceptions.InvalidLengthTelephoneException;
import Exceptions.ManagerException;
import Exceptions.NotAllowedCharacterException;
import View.AddHospitalView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerAddHospitalView {

    private final AddHospitalView hospital;
    Operations activities = new Operations();
    ArrayList<Patient> patients = activities.getPatients();
    ArrayList<Inscription> inscriptions = activities.getInscriptions();
    ArrayList<Hospital> hospitals = activities.getHospitals();
    int currentId;

    public ControllerAddHospitalView(AddHospitalView hospital) {
        this.hospital = hospital;
        initComponents();
    }

    private void initComponents() {
        hospital.getBtnAddHospital().addActionListener(this::addPatient);
    }

    private void addPatient(ActionEvent e) {
        try {
            ManagerException.EmptyField(hospital.getTxtName().getText(), "Name");
            ManagerException.EmptyField(hospital.getTxtAddress().getText(), "Address");
            ManagerException.TelephoneNumberValidation(hospital.getTxtTelephone().getText());
        } catch (EmptyFieldException | NotAllowedCharacterException | InvalidLengthTelephoneException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
        String name = hospital.getTxtName().getText();
        String telephone = hospital.getTxtTelephone().getText();
        String address = hospital.getTxtAddress().getText();

        int rowcount = activities.addHospitalMysql(name, address, telephone);

        cleanData();
    }

    public void cleanData() {
        hospital.getTxtName().setText("");
        hospital.getTxtAddress().setText("");
        hospital.getTxtTelephone().setText("");
    }

}
