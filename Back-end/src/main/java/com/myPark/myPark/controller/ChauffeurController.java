package com.myPark.myPark.controller;



import com.myPark.myPark.model.Chauffeur;
import com.myPark.myPark.service.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/myPark/chauffeur")
public class ChauffeurController {


    @Autowired
    ChauffeurService chauffeurService;

    @GetMapping("/listerId/{id}")
    public ResponseEntity<Chauffeur> chauffeurById (@PathVariable("id") Long id){
        Chauffeur chauffeur = chauffeurService.findChauffeurById(id);
        return new ResponseEntity<>(chauffeur, HttpStatus.OK);
    }

    @GetMapping("/lister")
    public ResponseEntity <List<Chauffeur>> chauffeur(){
        List<Chauffeur> chauffeur = chauffeurService.findAllChauffeur();
        return new ResponseEntity<>(chauffeur, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Chauffeur> ajoutChauffeur(@RequestBody Chauffeur chauffeur) {
        Chauffeur newChauffeur = chauffeurService.addChauffeur(chauffeur);
        return new ResponseEntity<>(newChauffeur, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Chauffeur> modifiChauffeur(@RequestBody Chauffeur chauffeur, @PathVariable("id") Long id) {
        Chauffeur updateChauffeur = chauffeurService.updateChauffeur(chauffeur, id);
        return new ResponseEntity<>(updateChauffeur, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimeChauffeur(@PathVariable("id") Long id) {
        chauffeurService.deleteChauffeur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/photoPermis/{id}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
    public byte[] photoPermis(@PathVariable("id") Long id) throws IOException {
        return chauffeurService.getPhotoPermis(id);
    }

    @GetMapping(value = "/photoCarte/{id}", produces = { MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public byte[] photoCarte(@PathVariable("id") Long id) throws IOException{
        return chauffeurService.getPhotoCarte(id);
    }

    @GetMapping("/allChauffeur/{sup}")
    public List<Chauffeur> allChauffeur(@PathVariable("sup") boolean sup){
        return chauffeurService.allChauffeur(sup);
    }
}
