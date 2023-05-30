package com.myPark.myPark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myPark.myPark.Profil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String quartier;
    private String ville;
    private String telephone;
    private String mdp;
    private final Profil profil = Profil.utilisateur;
    private boolean isSupprimer = false;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Location> location;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    List<Vendre> vendre;

    public Client() {
    }

    public Profil getProfil() {
        return profil;
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

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public List<Vendre> getVendre() {
        return vendre;
    }

    public void setVendre(List<Vendre> vendre) {
        this.vendre = vendre;
    }
}