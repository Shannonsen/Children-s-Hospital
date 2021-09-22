package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shannon
 */
public class Patient {
    String name; //Complete name
    String age;
    String gender;
    Date dateBirth;
    String originCity;
    Date dateInscription;
    String originHospital;
    String tutorName;
    String telephone;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public String getOriginCity() {
        return originCity;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public String getOriginHospital() {
        return originHospital;
    }

    public String getTutorName() {
        return tutorName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public void setOriginHospital(String originHospital) {
        this.originHospital = originHospital;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}
