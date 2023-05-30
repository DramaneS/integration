package com.myPark.myPark.service;


import com.myPark.myPark.model.ContratVente;
import com.myPark.myPark.repository.ContratVenteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContratVenteService {
    private final ContratVenteRepository contratVenteRepository;

    public ContratVenteService(ContratVenteRepository contratVenteRepository) {
        this.contratVenteRepository = contratVenteRepository;
    }

    public ContratVente addContrat(ContratVente contratVente) {
        return contratVenteRepository.save(contratVente);
    }

    public List<ContratVente> findAllContrat() {
        return contratVenteRepository.findAll();
    }

    public ContratVente findContratById(Long id) {
        return contratVenteRepository.findById(id).get();
    }

    @Transactional
    public void deleteContrat(Long id) {
        ContratVente contratVente = contratVenteRepository.getById(id);
        contratVente.setSupprimer(true);
        //contratVenteRepository.deleteById(id);
    }
    public List<ContratVente> allContratVente(boolean sup){
        return contratVenteRepository.findContratVenteBySupprimer(sup);
    }
}

