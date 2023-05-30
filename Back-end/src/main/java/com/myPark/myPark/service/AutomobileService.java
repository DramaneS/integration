package com.myPark.myPark.service;

import com.myPark.myPark.model.Automobile;
import com.myPark.myPark.model.Parking;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface AutomobileService {

    public Automobile addAutomobile(Automobile automobile, MultipartFile image) throws IOException;


    public byte[] getpHOTO(long Id) throws IOException;

    public Automobile updateAutomobile(Long id, Automobile automobile);

    public List<Automobile> listAutomobile();

    void deleteAutomobile(Long id);

    Automobile automobileById(Long id);

    public List<Automobile> findAutomobileByMaque(String marque);
    List<Automobile> findAutomobileByType(String type);
    List<Automobile> findAutomobileByMarque(String marque);
    List<Automobile> findAutomobileByModele(String model);
    List<Automobile> findAutomobileByMarqueAndModele(String marque,String modele);
    List<Automobile> allAutomobile(boolean sup);
}
