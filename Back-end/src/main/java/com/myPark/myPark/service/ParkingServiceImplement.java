package com.myPark.myPark.service;

import com.myPark.myPark.model.Parking;
import com.myPark.myPark.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingServiceImplement implements ParkingService{
    @Autowired
    ParkingRepository parkingRepository;
    @Override
    public String addParking(Parking parking) {
        parkingRepository.save(parking);
        return "Parking ajouté avec succès...";
    }

    @Override
    public Parking updateParking(Long id, Parking parking) {
        Parking mod = parkingRepository.getById(id);
        mod.setNom(parking.getNom());
        mod.setNom_gerant(parking.getNom_gerant());
        mod.setPrenom_gerant(parking.getPrenom_gerant());
        mod.setQuartier(parking.getQuartier());
        mod.setTelephone(parking.getTelephone());
        return parkingRepository.save(mod);
    }

    @Override
    public List<Parking> listParking() {
        return parkingRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteParking(Long id) {
        Parking parking = parkingRepository.getById(id);
        parking.setSupprimer(true);
        //parkingRepository.deleteById(id);
    }

    @Override
    public Parking parkingById(Long id) {
        return parkingRepository.findById(id).get();
    }

    /*
    @Override
    public Parking login(String telephone, String mdp) {
        Optional<Parking> connexion = parkingRepository.findParkingByTelephoneAndMdp(telephone, mdp);
        if (connexion.isEmpty()){
            return null;
        }
        return connexion.get();
    }
     */

    @Override
    public List<Parking> allParking(boolean sup) {
        return parkingRepository.findParkingBySupprimer(sup);
    }
}
