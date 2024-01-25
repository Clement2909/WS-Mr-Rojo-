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
public class Achat {
    
    private int id;
    private Date dateachat;
    private int id_car;
    private int id_user;

    public Achat() {
    }

    public Achat(int id, Date dateachat, int id_car, int id_user) {
        this.id = id;
        this.dateachat = dateachat;
        this.id_car = id_car;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateachat() {
        return dateachat;
    }

    public void setDateachat(Date dateachat) {
        this.dateachat = dateachat;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    
}
