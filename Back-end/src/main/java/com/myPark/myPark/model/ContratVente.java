package com.myPark.myPark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class ContratVente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateContratVente = LocalDate.now();
    private boolean isSupprimer = false;

    //@ManyToOne
    //private Client client;

    @ManyToOne
    private Vendre vendre;

    //@OneToMany(mappedBy = "contratVente")
    //@JsonIgnore
    //private List<Facture> facture;

    public ContratVente() {
    }

    public LocalDate getDateContratVente() {
        return dateContratVente;
    }

    public void setDateContratVente(LocalDate dateContratVente) {
        this.dateContratVente = dateContratVente;
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
