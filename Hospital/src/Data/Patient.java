package Data;

import java.sql.Date;

public class Patient {
    int id_patient;
    String name;
    String lastname;
    String age;
    String gender;
    java.sql.Date dateBirth;
    String originCity;
    String tutorName;
    String telephone;
    String typeBlood;

    public Patient(int id_patient, String name, String lastname, String age, String gender, Date dateBirth, String originCity, String tutorName, String telephone, String typeBlood) {
        this.id_patient = id_patient;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.originCity = originCity;
        this.tutorName = tutorName;
        this.telephone = telephone;
        this.typeBlood = typeBlood;
    }

    public int getId_patient() {
        return id_patient;
    }
   
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public java.sql.Date getDateBirth() {
        return dateBirth;
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getTutorName() {
        return tutorName;
    }

    public String getTypeBlood() {
        return typeBlood;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTypeBlood(String typeBlood) {
        this.typeBlood = typeBlood;
    }

}
