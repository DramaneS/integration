package com.myPark.myPark.controller;

import com.myPark.myPark.model.Automobile;
import com.myPark.myPark.repository.AutomobileRepository;
import com.myPark.myPark.service.AutomobileService;
import com.myPark.myPark.uploadFile.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/myPark/automobile")
public class AutomobileController {
    @Autowired
    AutomobileService automobileService;

    @Autowired
    AutomobileRepository automobileRepository;

    @PostMapping(value = "/ajouter")
    public Automobile addAutomobile(Automobile automobile,
                                       @RequestParam("image") MultipartFile multipartFile) throws IOException {
        return automobileService.addAutomobile(automobile, multipartFile);
    }

    @DeleteMapping(value = "/supprimer/{id}")
    public void delete(@PathVariable("id") Long id){
        automobileService.deleteAutomobile(id);
    }

    @PutMapping(value = "/modifier/{id}")
    public void update(@RequestBody Automobile automobile, @PathVariable Long id){
        automobileService.updateAutomobile(id,automobile);
    }

    @GetMapping(value = "/liste")
    @ResponseBody
    public List<Automobile> list(){return automobileService.listAutomobile();}

    @GetMapping(value = "/automobileById/{id}")
    public Automobile AutomobileById(@PathVariable("id") Long id) {
        return automobileService.automobileById(id);
    }

    @GetMapping(value = "/photo/{idphoto}", produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public byte[] getpHOTO(@PathVariable("idphoto") long Id) throws IOException {
        return automobileService.getpHOTO(Id);

    }

    @GetMapping(value = "automobileByType/{type}")
    public List<Automobile> findAutomobileByType(@PathVariable("type") String type){
        return automobileService.findAutomobileByType(type);
    }

    @GetMapping(value = "automobileByModele/{model}")
    public List<Automobile> findAutomobileByModele(@PathVariable("model") String model){
        return automobileService.findAutomobileByModele(model);
    }

    @GetMapping(value = "automobileByMarque/{marque}")
    public List<Automobile> findAutomobileByMarque(@PathVariable("marque") String marque){
        return automobileService.findAutomobileByMarque(marque);
    }

    @GetMapping(value = "automobileByMarqueAndModele/{marque}/{modele}")
    public List<Automobile> findAutomobileByMarqueAndModele(@PathVariable("marque") String marque, @PathVariable("modele") String modele){
        return automobileService.findAutomobileByMarqueAndModele(marque, modele);
    }

    @GetMapping("/allAutomobile/{sup}")
    public List<Automobile> allAutomobile(@PathVariable("sup") boolean sup){
        return automobileService.allAutomobile(sup);
    }

}
