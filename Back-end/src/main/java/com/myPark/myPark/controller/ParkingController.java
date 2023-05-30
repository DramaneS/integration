package com.myPark.myPark.controller;

import com.myPark.myPark.model.Parking;
import com.myPark.myPark.repository.ParkingRepository;
import com.myPark.myPark.service.ParkingServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/myPark/parking")
@CrossOrigin("*")
public class ParkingController {
    @Autowired
    ParkingServiceImplement parkingService;

    @Autowired
    ParkingRepository parkingRepository;

    @PostMapping(value = "/ajouter")
    public void save(@RequestBody Parking parking){
        parkingService.addParking(parking);
    }

    @DeleteMapping(value = "/supprimer/{id}")
    public void delete(@PathVariable("id") Long id){
        parkingService.deleteParking(id);
    }

    @PutMapping(value = "/modifier/{id}")
    public void update(@RequestBody Parking parking, @PathVariable Long id){
        parkingService.updateParking(id,parking);
    }

    @GetMapping(value = "/lister")
    @ResponseBody
    public List<Parking> list(){return parkingService.listParking();}

    @GetMapping(value = "/listerId/{id}")
    public Parking ParkingById(@PathVariable("id") Long id) {
        return parkingService.parkingById(id);
    }

    /*
    @GetMapping("/login/{telephone}&{mdp}")
    Parking login(@PathVariable("telephone") String telephone, @PathVariable("mdp") String mdp){
        return parkingService.login(telephone, mdp);
    }
     */

    @GetMapping("/allParking/{sup}")
    List<Parking> allParking(@PathVariable("sup") boolean sup){
        return parkingService.allParking(sup);
    }
}
