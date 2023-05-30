package com.myPark.myPark.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class TypeAutomobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private boolean isSupprimer = false;



    public TypeAutomobile() {
    }

    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSupprimer() {
        return isSupprimer;
    }

    public void setSupprimer(boolean supprimer) {
        isSupprimer = supprimer;
    }


}
