/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.back.wsrojo.model;

/**
 *
 * @author Toavina Raza
 */
public class Car {
    
    private int id;
    private String matricule;
    private int anneefabrication;
    private int kilometrage;
    private String moteur;
    private String transmission;
    private int etat;
    private String infos;
    private int id_brand;
    private int id_category;
    private int id_color;

    public Car() {
    }

    public Car(int id, String matricule, int anneefabrication, int kilometrage, String moteur, String transmission, int etat, String infos, int id_brand, int id_category, int id_color) {
        this.id = id;
        this.matricule = matricule;
        this.anneefabrication = anneefabrication;
        this.kilometrage = kilometrage;
        this.moteur = moteur;
        this.transmission = transmission;
        this.etat = etat;
        this.infos = infos;
        this.id_brand = id_brand;
        this.id_category = id_category;
        this.id_color = id_color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getAnneefabrication() {
        return anneefabrication;
    }

    public void setAnneefabrication(int anneefabrication) {
        this.anneefabrication = anneefabrication;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getMoteur() {
        return moteur;
    }

    public void setMoteur(String moteur) {
        this.moteur = moteur;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getId_color() {
        return id_color;
    }

    public void setId_color(int id_color) {
        this.id_color = id_color;
    }
    
    
    
}
