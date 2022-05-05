package Data;

import java.sql.Date;

public class Inscription {
    int id_inscription;
    int id_patient;
    int id_hospital;
    java.sql.Date date_inscription;

    public Inscription(int id_inscription, int id_patient, int id_hospital, Date date_inscription) {
        this.id_inscription = id_inscription;
        this.id_patient = id_patient;
        this.id_hospital = id_hospital;
        this.date_inscription = date_inscription;
    }

    public int getId_inscription() {
        return id_inscription;
    }

    public int getId_patient() {
        return id_patient;
    }

    public int getId_hospital() {
        return id_hospital;
    }

    public Date getDate_inscription() {
        return date_inscription;
    }

}
