package com.myPark.myPark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myPark.myPark.Profil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String nomUtilisateur;
    private String mdp;
    private final Profil profil = Profil.Admin;
    private boolean isSupprimer = false;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Parking> parking;

    public Admin() {
    }

    public Profil getProfil() {
        return profil;
    }

    public List<Parking> getParking() {
        return parking;
    }

    public void setParking(List<Parking> parking) {
        this.parking = parking;
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

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
}
