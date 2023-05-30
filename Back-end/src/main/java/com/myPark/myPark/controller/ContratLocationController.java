package com.myPark.myPark.controller;

import com.myPark.myPark.model.ContratLocation;
import com.myPark.myPark.service.ContratLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/myPark/contratLocation")
public class ContratLocationController {

    @Autowired
    ContratLocationService contratLocationService;

    @GetMapping("/listerId/{id}")
    public ResponseEntity<ContratLocation> contratById (@PathVariable("id") Long id) {
        ContratLocation contratLocation = contratLocationService.findContratById(id);
        return new ResponseEntity<>(contratLocation, HttpStatus.OK);
    }

    @GetMapping("/lister")
    public ResponseEntity <List<ContratLocation>> contrat() {
        List<ContratLocation> contratLocation = contratLocationService.findAllContrat();
        return new ResponseEntity<>(contratLocation, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<ContratLocation> ajoutContrat(@RequestBody ContratLocation contratLocation) {
        ContratLocation newContrat = contratLocationService.addContrat(contratLocation);
        return new ResponseEntity<>(newContrat, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<ContratLocation> modifiContrat(@RequestBody ContratLocation contratLocation, @PathVariable("id") Long id) {
        ContratLocation updateContrat = contratLocationService.updateContrat(contratLocation, id);
        return new ResponseEntity<>(updateContrat, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimeContrat(@PathVariable("id") Long id) {
        contratLocationService.deleteContrat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allContratLocation/{sup}")
    public List<ContratLocation> allContratLocation(@PathVariable("sup") boolean sup){
        return contratLocationService.allContratLocation(sup);
    }
}