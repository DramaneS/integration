package com.myPark.myPark.service;

import com.myPark.myPark.model.Automobile;
import com.myPark.myPark.model.Chauffeur;
import com.myPark.myPark.repository.ChauffeurRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ChauffeurService {
    private final ChauffeurRepository chauffeurRepository;


    public ChauffeurService(ChauffeurRepository chauffeurRepository){
        this.chauffeurRepository = chauffeurRepository;
    }

    public Chauffeur addChauffeur(Chauffeur chauffeur){
        return chauffeurRepository.save(chauffeur);
    }

    public List<Chauffeur> findAllChauffeur() {
        return chauffeurRepository.findAll();
    }

    public Chauffeur updateChauffeur(Chauffeur chauffeur, Long id) {
        Chauffeur moChauffeur = chauffeurRepository.findById(id).get();
        moChauffeur.setNom(chauffeur.getNom());
        moChauffeur.setPrenom(chauffeur.getPrenom());
        moChauffeur.setTelephone(chauffeur.getTelephone());
       // moChauffeur.setNumeroPermis(chauffeur.getNumeroPermis());
        moChauffeur.setPhotoPermis(chauffeur.getPhotoPermis());
        moChauffeur.setPhotoCarte(chauffeur.getPhotoCarte());

        return chauffeurRepository.save(moChauffeur);
    }

    public Chauffeur findChauffeurById(Long id){

        return chauffeurRepository.findById(id).get();
    }
    @Transactional
    public void deleteChauffeur(Long id) {
        Chauffeur chauffeur = chauffeurRepository.getById(id);
        chauffeur.setSupprimer(true);
        //chauffeurRepository.deleteById(id);
    }
    public byte[] getPhotoCarte(long Id) throws IOException {
        Chauffeur aut = chauffeurRepository.findById(Id).get();
        String iconPhoto = aut.getPhotoCarte();
        File file = new File("src/main/resources/photo/"+ aut.getId() +"/" +iconPhoto);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    public byte[] getPhotoPermis(long Id) throws IOException {
        Chauffeur aut = chauffeurRepository.findById(Id).get();
        String iconPhoto = aut.getPhotoPermis();
        File file = new File("src/main/resources/photo/"+ aut.getId() +"/" +iconPhoto);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
    public List<Chauffeur> allChauffeur(boolean sup){
        return chauffeurRepository.findChauffeurBySupprimer(sup);
    }
}
