package com.myPark.myPark.repository;

import com.myPark.myPark.model.Automobile;
import com.myPark.myPark.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AutomobileRepository extends JpaRepository<Automobile, Long> {
    //Automobile par marque
    @Query(value = "SELECT marque FROM Automobile marque WHERE marque.marque = :marque")
    List<Automobile> findAutomobileByMarque(@Param("marque") String marque);

    //Automibile par son model
    @Query(value = "SELECT model FROM Automobile model WHERE model.modele = :model")
    List<Automobile> findAutomobileByModele(@Param("model") String model);

    //Automibile par son model
    @Query(value = "SELECT model FROM Automobile model WHERE model.marque = :marque AND model.modele = :model")
    List<Automobile> findAutomobileByMarqueAndModele(@Param("marque") String marque, @Param("model") String model);

    @Query(value = "SELECT sup FROM Automobile sup WHERE sup.isSupprimer = false")
    List<Automobile> findAutomobileBySupprimer(@Param("sup") boolean sup);

    List<Automobile> findAutomobileByType(String type);
}
