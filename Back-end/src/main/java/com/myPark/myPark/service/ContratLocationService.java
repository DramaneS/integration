package com.myPark.myPark.service;


import com.myPark.myPark.model.ContratLocation;
import com.myPark.myPark.repository.ContratLocationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContratLocationService {
    private final ContratLocationRepository contratLocationRepository;

    public ContratLocationService(ContratLocationRepository contratLocationRepository) {
        this.contratLocationRepository = contratLocationRepository;
    }

    public ContratLocation addContrat(ContratLocation contratLocation) {
        return contratLocationRepository.save(contratLocation);
    }

    public List<ContratLocation> findAllContrat() {
        return contratLocationRepository.findAll();
    }

    public ContratLocation updateContrat(ContratLocation contratLocation, Long id) {
        ContratLocation moContrat = contratLocationRepository.findById(id).get();
        moContrat.setDateDepart(contratLocation.getDateDepart());
        moContrat.setDateRetour(contratLocation.getDateRetour());
        moContrat.setDestination(contratLocation.getDestination());
        moContrat.setTermesConditions(contratLocation.getTermesConditions());

        return contratLocationRepository.save(moContrat);
    }

    public ContratLocation findContratById(Long id) {
        return contratLocationRepository.findById(id).get();
    }

    @Transactional
    public void deleteContrat(Long id) {
        ContratLocation location = contratLocationRepository.getById(id);
        location.setSupprimer(true);
        //contratLocationRepository.deleteById(id);
    }

    public List<ContratLocation> allContratLocation(boolean sup){
        return contratLocationRepository.findContratLocationBySupprimer(sup);
    }

}
