package Data;

import java.sql.Date;

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

    String name;
    String lastname;
    int age;
    String gender;
    java.sql.Date dateBirth;
    String originCity;
    String tutorName;
    int telephone;

    public Patient(String name, String lastname, int age, String gender, java.sql.Date dateBirth, String originCity, String tutorName, int telephone) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.originCity = originCity;
        this.tutorName = tutorName;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
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

    public int getTelephone() {
        return telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
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

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

}
