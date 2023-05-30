package com.myPark.myPark.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateFacture = LocalDate.now();
    private String montantTotal;
    private String montantPaye;
    private String restePayer;
    private boolean isSupprimer = false;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Vendre vendre;


    //@ManyToOne
    //private ContratVente contratVente;

    public Facture() {
    }

    public LocalDate getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDate dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(String montantTotal) {
        this.montantTotal = montantTotal;
    }

    public String getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(String montantPaye) {
        this.montantPaye = montantPaye;
    }

    public String getRestePayer() {
        return restePayer;
    }

    public void setRestePayer(String restePayer) {
        this.restePayer = restePayer;
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
