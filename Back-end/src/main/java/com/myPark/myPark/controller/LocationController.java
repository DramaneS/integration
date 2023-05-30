package com.myPark.myPark.controller;

import com.myPark.myPark.model.Location;
import com.myPark.myPark.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
    @RequestMapping("myPark/location")
public class LocationController {
    @Autowired
    LocationServiceImpl locationService;

    @GetMapping(value = "listerId/{id}")
    public ResponseEntity<Location> locationById (@PathVariable("id") Long id){
        Location location = locationService.listerById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping(value = "/lister")
    public ResponseEntity<List<Location>> location(){
        List<Location> location = locationService.lister();
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public Location addLocation(@RequestBody Location location){
        return locationService.ajouter(location);
    }

    @PutMapping(value = "/modifier/{id}")
    public void update(@RequestBody Location location, @PathVariable Long id){
        locationService.modifier(location, id);
    }

    @DeleteMapping(value = "/supprimer/{id}")
    public ResponseEntity<?> supprimerLocation(@PathVariable("id") Long id){
        locationService.supprimer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allLocation/{sup}")
    List<Location> allLocation(@PathVariable("sup") boolean sup){
        return locationService.liste(sup);
    }

    @PutMapping("/modifierStatus/{id}")
    Location modifierStatus(@RequestBody Location location, @PathVariable("id") Long id){
        return locationService.modifierStatus(location, id);
    }
}