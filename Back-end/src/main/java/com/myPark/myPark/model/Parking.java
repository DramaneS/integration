package com.myPark.myPark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotNull(message = "Veuillez renseigner le nom du parking...")
    private String nom;
    //@NotNull(message = "Veuillez renseigner le nom du gérant...")
    private String nom_gerant;
    private String prenom_gerant;
    private String email;
    //private String mdp;
    public String getLogin() {
        return email;
    }

    public void setLogin(String email) {
        this.email = email;
    }

    private String quartier;
    //@NotNull(message = "Veuillez renseigner le numéro de téléphone...")

    private String telephone;
    private boolean isSupprimer = false;

    @ManyToOne
    private Admin admin;

    //@OneToMany(mappedBy = "parking", cascade = CascadeType.ALL)
    //@JsonIgnore
    //private List<Chauffeur> chauffeur;

    @OneToMany(mappedBy = "parking", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Automobile> automobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parking() {
    }


    //public String getMdp() {
    //    return mdp;
   // }

    //public void setMdp(String mdp) {
     //   this.mdp = mdp;
    //}

    public Parking(long id, String nom, String nom_gerant, String prenom_gerant, String quartier, String telephone, String email, String mdp) {
        this.id = id;
        this.nom = nom;
        this.nom_gerant = nom_gerant;
        this.prenom_gerant = prenom_gerant;
        this.quartier = quartier;
        this.telephone = telephone;
        this.email = email;
     //   this.mdp = mdp;
    }

    public void setId_parking(Long id_parking) {
        this.id = id_parking;
    }

    public long getId_parking() {
        return id;
    }

    public void setId_parking(long id_parking) {
        this.id = id_parking;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_gerant() {
        return nom_gerant;
    }

    public void setNom_gerant(String nom_gerant) {
        this.nom_gerant = nom_gerant;
    }

    public String getPrenom_gerant() {
        return prenom_gerant;
    }

    public void setPrenom_gerant(String prenom_gerant) {
        this.prenom_gerant = prenom_gerant;
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

    public boolean isSupprimer() {
        return isSupprimer;
    }

    public void setSupprimer(boolean supprimer) {
        isSupprimer = supprimer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    //public List<Chauffeur> getChauffeur() {
      //  return chauffeur;
    //}

    //public void setChauffeur(List<Chauffeur> chauffeur) {
      //  this.chauffeur = chauffeur;
    //}

    public List<Automobile> getAutomobile() {
        return automobile;
    }

    public void setAutomobile(List<Automobile> automobile) {
        this.automobile = automobile;
    }
}