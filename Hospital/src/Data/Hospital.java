/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Shannon
 */
public class Hospital {
    int id_hospital;
    String name;
    String address;
    int telephone;

    public Hospital(int id_hospital,String name, String address, int telephone) {
        this.id_hospital= id_hospital;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public int getId_hospital() {
        return id_hospital;
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
        
}
