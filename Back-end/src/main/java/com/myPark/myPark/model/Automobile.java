package com.myPark.myPark.model;

import javax.persistence.*;


@Entity
public class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroMatricule;
    private String marque;
    private Integer prixLocation;
    private Integer prixVente;
    private String modele;
    private Long annee;
    private Long nbrePlace;
    private String carburant;
    @Column(name = "photo")
    private String photos;
    @ManyToOne
    private TypeAutomobile type;
    private boolean isSupprimer = false;
    private boolean disponibilite = true;

    @ManyToOne
    private Parking parking;

    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Chauffeur chauffeur;


    public Automobile() {
    }

    public Automobile(Long id, String numeroMatricule, String marque, String modele, Long annee, Long nbrePlace, String carburant, String photos, TypeAutomobile type, boolean isSupprimer, boolean disponibilité) {
        this.id = id;
        this.numeroMatricule = numeroMatricule;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.nbrePlace = nbrePlace;
        this.carburant = carburant;
        this.photos = photos;
        this.type = type;
        this.isSupprimer = isSupprimer;
        this.disponibilite = disponibilite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMatricule() {
        return numeroMatricule;
    }

    public void setNumeroMatricule(String numeroMatricule) {
        this.numeroMatricule = numeroMatricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Long getAnnee() {
        return annee;
    }

    public void setAnnee(Long annee) {
        this.annee = annee;
    }

    public Long getNbrePlace() {
        return nbrePlace;
    }

    public void setNbrePlace(Long nbrePlace) {
        this.nbrePlace = nbrePlace;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Integer getPrixLocation() {
        return prixLocation;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public void setPrixLocation(Integer prixLocation) {
        this.prixLocation = prixLocation;
    }

    public Integer getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Integer prixVente) {
        this.prixVente = prixVente;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public TypeAutomobile getType() {
        return type;
    }

    public void setType(TypeAutomobile type) {
        this.type = type;
    }

    public boolean isSupprimer() {
        return isSupprimer;
    }

    public void setSupprimer(boolean supprimer) {
        isSupprimer = supprimer;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

}
