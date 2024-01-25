/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.model;

import java.sql.Date;

/**
 *
 * @author Toavina Raza
 */
public class Annonce {
    
    private int id;
    private int id_car;
    private Date datepub;
    private float prix;
    private int id_user;

    public Annonce() {
    }

    public Annonce(int id, int id_car, Date datepub, float prix, int id_user) {
        this.id = id;
        this.id_car = id_car;
        this.datepub = datepub;
        this.prix = prix;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public Date getDatepub() {
        return datepub;
    }

    public void setDatepub(Date datepub) {
        this.datepub = datepub;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    
}
