package com.myPark.myPark.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Chauffeur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String telephone;

    private String photoPermis;

    private String photoCarte;
    @Column()
    private String quartier;

    @ManyToOne
    private Parking parking;

    @ManyToOne
    private Admin admin;

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    private boolean isSupprimer = false;


    public Chauffeur() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    //public String getNumeroPermis() {
      //  return numeroPermis;
   // }

   // public void setNumeroPermis(String numeroPermis) {
       // this.numeroPermis = numeroPermis;
    //}

    public String getPhotoPermis() {
        return photoPermis;
    }

    public void setPhotoPermis(String photoPermis) {
        this.photoPermis = photoPermis;
    }

    public String getPhotoCarte() {
        return photoCarte;
    }

    public void setPhotoCarte(String photoCarte) {
        this.photoCarte = photoCarte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSupprimer() {
        return isSupprimer;
    }

    public void setSupprimer(boolean supprimer) {
        isSupprimer = supprimer;
    }

    //public Parking getParking() {
      //  return parking;
    //}

    //public void setParking(Parking parking) {
      //  this.parking = parking;
    //}
}
