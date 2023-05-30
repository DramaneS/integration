package com.myPark.myPark.service;

import com.myPark.myPark.model.TypeAutomobile;
import com.myPark.myPark.repository.TypeAutomobileRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypeAutomobileService {
    TypeAutomobileRepository typeAutomobileRepository;

    public TypeAutomobileService(TypeAutomobileRepository typeAutomobileRepository){
        this.typeAutomobileRepository = typeAutomobileRepository;
    }

    public TypeAutomobile addTypeAutomobile(TypeAutomobile typeAutomobile){
        return typeAutomobileRepository.save(typeAutomobile);
    }

    public List<TypeAutomobile> findAllTypeAutomobile(){
        return typeAutomobileRepository.findAll();
    }

    public TypeAutomobile updateTypeAutomobile(TypeAutomobile typeAutomobile, Long id){
        TypeAutomobile moTypeAutomobile = typeAutomobileRepository.findById(id).get();
        moTypeAutomobile.setDescription(typeAutomobile.getDescription());
        return typeAutomobileRepository.save(moTypeAutomobile);
    }

    public TypeAutomobile findTypeAutomobileById(Long id){
        return typeAutomobileRepository.findById(id).get();
    }

    @Transactional
    public void deleteTypeAutomobile(Long id){
        TypeAutomobile typeAutomobile = typeAutomobileRepository.getById(id);
        typeAutomobile.setSupprimer(true);
    }

}
