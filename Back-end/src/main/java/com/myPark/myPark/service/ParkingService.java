package com.myPark.myPark.service;

import com.myPark.myPark.model.Parking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ParkingService {
    public String addParking(Parking parking);
    public Parking updateParking(Long id, Parking parking);
    public List<Parking> listParking();
    void deleteParking(Long id);
    Parking parkingById(Long id);
    //Parking login(String email, String mdp);
    public List<Parking> allParking(boolean sup);
}
