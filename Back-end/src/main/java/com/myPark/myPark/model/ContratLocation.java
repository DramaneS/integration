package com.myPark.myPark.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
public class ContratLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateContratLocation = LocalDate.now();
    private LocalDate dateDepart;
    private LocalDate dateRetour;
    private String destination;
    private String termesConditions;
    private boolean isSupprimer = false;

    @ManyToOne
    private Location location;

    public ContratLocation() {
    }

    public LocalDate getDateContratLocation() {
        return dateContratLocation;
    }

    public void setDateContratLocation(LocalDate dateContratLocation) {
        this.dateContratLocation = dateContratLocation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTermesConditions() {
        return termesConditions;
    }

    public void setTermesConditions(String termesConditions) {
        this.termesConditions = termesConditions;
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
