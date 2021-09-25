package View;

import Controller.ControllerHospitalView;

/**
 *
 * @author Shannon
 */
public class Main {

    public static void main(String[] args) {
        HospitalView hospitalview = new HospitalView();
        hospitalview.setLocationRelativeTo(null);
        hospitalview.setVisible(true);
        new ControllerHospitalView(hospitalview);
    }

}
