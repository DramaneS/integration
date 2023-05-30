package com.myPark.myPark.controller;


import com.myPark.myPark.model.Automobile;
import com.myPark.myPark.model.Client;
import com.myPark.myPark.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("myPark/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(value = "/listerId/{id}")
    public ResponseEntity<Client> clientById (@PathVariable("id") Long id){
        Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping(value = "/lister")
    public  ResponseEntity<List<Client>> client(){
        List<Client> client = clientService.findAllClient();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }


    @PutMapping(value = "/modifier/{id}")
    public void update(@RequestBody Client client, @PathVariable Long id){
        clientService.updateClient(id,client);
    }


    @DeleteMapping(value = "/supprimer/{id}")
    public ResponseEntity<?> supprimeClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login/{telephone}&{mdp}")
    Client login(@PathVariable("telephone") String telephone, @PathVariable("mdp") String mdp){
        return clientService.login(telephone, mdp);
    }

    @GetMapping("/allClient/{sup}")
    List<Client> allClient(@PathVariable("sup") boolean sup){
        return clientService.allClient(sup);
    }
}