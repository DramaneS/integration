package com.myPark.myPark.service;

import com.myPark.myPark.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface LocationService  {
    Location ajouter(Location location);
    Location modifier(Location location, Long id);
    void supprimer(Long id);
    Location listerById(Long id);
    List<Location> lister();
    List<Location> liste(boolean sup);
    Location modifierStatus(Location location, Long id);

}
