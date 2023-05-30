package com.myPark.myPark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myPark.myPark.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateLocation = LocalDate.now();
    private Status status;

    @ManyToOne
    @JoinColumn(name = "automobile_id")
    private Automobile automobile;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<ContratLocation> contratLocation;

    @ManyToOne
    private Client client;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Facture> facture;

    private boolean isSupprimer = false;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Facture> getFacture() {
        return facture;
    }

    public void setFacture(List<Facture> facture) {
        this.facture = facture;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public Location() {
    }

    public LocalDate getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(LocalDate dateLocation) {
        this.dateLocation = dateLocation;
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

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

    public List<ContratLocation> getContratLocation() {
        return contratLocation;
    }

    public void setContratLocation(List<ContratLocation> contratLocation) {
        this.contratLocation = contratLocation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}