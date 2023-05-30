package com.myPark.myPark.service;


import com.myPark.myPark.exception.ErrorCode;
import com.myPark.myPark.exception.InvalidEntityException;
import com.myPark.myPark.model.Client;
import com.myPark.myPark.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }


    public Client updateClient(Long id, Client client) {
        Client cliet = clientRepository.getById(id);
        cliet.setPrenom(client.getPrenom());
        cliet.setNom(client.getNom());
        cliet.setTelephone(client.getTelephone());
        cliet.setLocation(client.getLocation());
        cliet.setMdp(client.getMdp());
        cliet.setQuartier(client.getQuartier());
        cliet.setVille(client.getVille());
        return clientRepository.save(cliet);
    }

    public List<Client> findAllClient(){
        return clientRepository.findAll();
    }

    public Client findClientById(Long id){
        return clientRepository.findById(id).get();
    }

    @Transactional
    public void deleteClient(Long id){
        Client client = clientRepository.getById(id);
        client.setSupprimer(true);
    }

    public Client login(String telephone, String mdp){
        Optional<Client> connexion = clientRepository.findByTelephoneAndMdp(telephone, mdp);
        if (connexion.isEmpty()){
            return null;
            //throw new InvalidEntityException("Login ou mot de passe incorrect", ErrorCode.CLIENT_AUTH);
        }
        return connexion.get();
    }

    public List<Client> allClient(boolean sup){
        return clientRepository.findClientBySupprimer(sup);
    }
}