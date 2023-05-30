package com.myPark.myPark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Vendre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateAchat;
    private String clausesVente;
    private String prix;
    private boolean isSupprimer = false;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Automobile automobile;

    //@OneToMany(mappedBy = "vendre", cascade = CascadeType.ALL)
    //private List<Facture> facture;


    public Vendre() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public String getClausesVente() {
        return clausesVente;
    }

    public void setClausesVente(String clausesVente) {
        this.clausesVente = clausesVente;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
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
