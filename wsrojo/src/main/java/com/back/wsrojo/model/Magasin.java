/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.model;

/**
 *
 * @author Toavina Raza
 */
public class Magasin {
    
    private int id;
    private String status;
    private int id_user;
    private int id_car;

    public Magasin() {
    }

    public Magasin(int id, String status, int id_user, int id_car) {
        this.id = id;
        this.status = status;
        this.id_user = id_user;
        this.id_car = id_car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }
    
    
}
