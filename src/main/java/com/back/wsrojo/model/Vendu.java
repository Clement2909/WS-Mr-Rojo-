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
public class Vendu {
    
    private int id;
    private int id_annonce;
    private int id_commission;
    private Date datevente;

    public Vendu() {
    }

    public Vendu(int id, int id_annonce, int id_commission, Date datevente) {
        this.id = id;
        this.id_annonce = id_annonce;
        this.id_commission = id_commission;
        this.datevente = datevente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_commission() {
        return id_commission;
    }

    public void setId_commission(int id_commission) {
        this.id_commission = id_commission;
    }

    public Date getDatevente() {
        return datevente;
    }

    public void setDatevente(Date datevente) {
        this.datevente = datevente;
    }
    
    
}
