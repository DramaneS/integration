package com.myPark.myPark.repository;

import com.myPark.myPark.model.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
    @Query(value = "SELECT sup FROM Chauffeur sup WHERE sup.isSupprimer = false")
    List<Chauffeur> findChauffeurBySupprimer(@Param("sup") boolean sup);
}
