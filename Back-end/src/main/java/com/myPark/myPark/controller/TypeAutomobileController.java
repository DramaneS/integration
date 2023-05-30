package com.myPark.myPark.controller;

import com.myPark.myPark.model.TypeAutomobile;
import com.myPark.myPark.service.TypeAutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/myPark/typeAutomobile")
public class TypeAutomobileController {

    @Autowired
    TypeAutomobileService typeAutomobileService;

    @GetMapping("/listerId/{id}")
    public ResponseEntity<TypeAutomobile> typeAutomobileById (@PathVariable("id") Long id){
        TypeAutomobile typeAutomobile = typeAutomobileService.findTypeAutomobileById(id);
        return new ResponseEntity<>(typeAutomobile, HttpStatus.OK);
    }

    @GetMapping("/lister")
    public ResponseEntity <List<TypeAutomobile>> typeAutomobile(){
        List<TypeAutomobile> typeAutomobile = typeAutomobileService.findAllTypeAutomobile();
        return new ResponseEntity<>(typeAutomobile, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<TypeAutomobile> ajoutTypeAutomobile(@RequestBody TypeAutomobile typeAutomobile){
        TypeAutomobile newTypeAutomobile = typeAutomobileService.addTypeAutomobile(typeAutomobile);
        return new ResponseEntity<>(newTypeAutomobile, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<TypeAutomobile> modifiTypeAutomobile(@RequestBody TypeAutomobile typeAutomobile, @PathVariable("id") Long id){
        TypeAutomobile updateTypeAutomobile = typeAutomobileService.updateTypeAutomobile(typeAutomobile, id);
        return new ResponseEntity<>(updateTypeAutomobile, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerTypeAutomobile(@PathVariable("id") Long id){
        typeAutomobileService.deleteTypeAutomobile(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}