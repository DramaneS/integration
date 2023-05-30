package com.myPark.myPark.service;

import com.myPark.myPark.Status;
import com.myPark.myPark.model.Location;
import com.myPark.myPark.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location ajouter(Location location) {
        location.setStatus(Status.initié);
        return locationRepository.save(location);
    }

    @Override
    public Location modifier(Location location, Long id) {
        Location modifierLocation = locationRepository.findById(id).get();
        modifierLocation.setStatus(location.getStatus());
        return locationRepository.save(modifierLocation);
    }

    @Override
    @Transactional
    public void supprimer(Long id) {
        Location location = locationRepository.findById(id).get();
        location.setSupprimer(true);
        locationRepository.save(location);

    }


    @Override
    public Location listerById(Long id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public List<Location> lister() {
        return locationRepository.findAll();
    }

    @Override
    public List<Location> liste(boolean sup) {
        return locationRepository.findLocationBySupprimer(sup);
    }

    @Transactional
    @Override
    public Location modifierStatus(Location location, Long id) {
        Location locationFound = locationRepository.findById(id).get();;
        if (locationFound.getStatus() == Status.initié){
            locationFound.setStatus(Status.encours);
        }
        else if (locationFound.getStatus() == Status.encours){
            locationFound.setStatus(Status.terminé);
        }
        else {
            locationFound.setStatus(Status.terminé);
        }
        return locationRepository.save(locationFound);
    }
}
