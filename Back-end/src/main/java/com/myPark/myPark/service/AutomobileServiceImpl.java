package com.myPark.myPark.service;

import com.myPark.myPark.model.Automobile;
import com.myPark.myPark.model.FileUploadUtil;
import com.myPark.myPark.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AutomobileServiceImpl implements AutomobileService{

    @Autowired
    AutomobileRepository automobileRepository;

    @Override
    public Automobile addAutomobile(Automobile automobile,
                @RequestParam("image") MultipartFile multipartFilePhoto) throws IOException {
            String fileNamePhoto = StringUtils.cleanPath(multipartFilePhoto.getOriginalFilename());
            automobile.setPhotos(fileNamePhoto);
            Automobile aut = automobileRepository.save(automobile);
            String uploadDirPhoto = "src/main/resources/photo/" + aut.getId();
            FileUploadUtil.saveFile(uploadDirPhoto, fileNamePhoto, multipartFilePhoto);
            return aut;
        }

    @Override
    public byte[] getpHOTO(long Id) throws IOException {
        Automobile aut = automobileRepository.findById(Id).get();
        String iconPhoto = aut.getPhotos();
        File file = new File("src/main/resources/photo/"+ aut.getId() +"/" +iconPhoto);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @Override
    public Automobile updateAutomobile(Long id, Automobile automobile) {
        Automobile auto = automobileRepository.getById(id);
        auto.setPhotos(automobile.getPhotos());
        auto.setAnnee(automobile.getAnnee());
        auto.setMarque(automobile.getMarque());
        auto.setModele(automobile.getModele());
        auto.setNbrePlace(automobile.getNbrePlace());
        auto.setNumeroMatricule(automobile.getNumeroMatricule());
        auto.setType(automobile.getType());
        auto.setParking(automobile.getParking());
        auto.setPrixLocation(automobile.getPrixLocation());
        auto.setPrixVente(automobile.getPrixVente());
        auto.setCarburant(automobile.getCarburant());
        return automobileRepository.save(auto);
    }

    @Override
    public List<Automobile> listAutomobile() {
        return automobileRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteAutomobile(Long id) {
        Automobile automobile = automobileRepository.findById(id).get();
        automobile.setSupprimer(true);
        //automobileRepository.deleteById(id);

    }

    @Override
    public Automobile automobileById(Long id) {
        return automobileRepository.findById(id).get();
    }

    @Override
    public List<Automobile> findAutomobileByMaque(String marque) {
        return automobileRepository.findAll();
    }

    @Override
    public List<Automobile> findAutomobileByType(String type) {
        return automobileRepository.findAutomobileByType(type);
    }

    @Override
    public List<Automobile> findAutomobileByMarque(String marque) {
        return automobileRepository.findAutomobileByMarque(marque);
    }

    @Override
    public List<Automobile> findAutomobileByModele(String model) {
        return automobileRepository.findAutomobileByModele(model);
    }

    @Override
    public List<Automobile> findAutomobileByMarqueAndModele(String marque, String modele) {
        return automobileRepository.findAutomobileByMarqueAndModele(marque, modele);
    }

    @Override
    public List<Automobile> allAutomobile(boolean sup){
        return automobileRepository.findAutomobileBySupprimer(sup);
    }

}
