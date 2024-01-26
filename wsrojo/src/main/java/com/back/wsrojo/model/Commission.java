/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.model;

/**
 *
 * @author Toavina Raza
 */
public class Commission {
    
    private int id;
    private int id_category;
    private float prixpourcentage;

    public Commission() {
    }

    public Commission(int id, int id_category, float prixpourcentage) {
        this.id = id;
        this.id_category = id_category;
        this.prixpourcentage = prixpourcentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public float getPrixpourcentage() {
        return prixpourcentage;
    }

    public void setPrixpourcentage(float prixpourcentage) {
        this.prixpourcentage = prixpourcentage;
    }
    
    
}
