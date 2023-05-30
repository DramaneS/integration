package com.myPark.myPark.controller;


import com.myPark.myPark.model.ContratVente;
import com.myPark.myPark.service.ContratVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/myPark/contratVente")
public class ContratVenteController {

    @Autowired
    ContratVenteService contratVenteService;

    @GetMapping("/listerId/{id}")
    public ResponseEntity<ContratVente> contratById (@PathVariable("id") Long id) {
        ContratVente contratVente = contratVenteService.findContratById(id);
        return new ResponseEntity<>(contratVente, HttpStatus.OK);
    }


    @GetMapping("/lister")
    public ResponseEntity <List<ContratVente>> contrat(){
        List<ContratVente> contratVente = contratVenteService.findAllContrat();
        return new ResponseEntity<>(contratVente, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<ContratVente> ajoutContrat(@RequestBody ContratVente contratVente) {
        ContratVente newContrat = contratVenteService.addContrat(contratVente);
        return new ResponseEntity<>(newContrat, HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimeContrat(@PathVariable("id") Long id) {
        contratVenteService.deleteContrat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allContratVente/{sup}")
    public List<ContratVente> allContratVente(@PathVariable("sup") boolean sup){
        return contratVenteService.allContratVente(sup);
    }
}

/*
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimeChauffeur(@PathVariable("id") Long id) {
        chauffeurService.deleteChauffeur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

 */
