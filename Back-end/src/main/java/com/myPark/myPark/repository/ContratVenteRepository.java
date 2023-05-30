package com.myPark.myPark.repository;

import com.myPark.myPark.model.ContratVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratVenteRepository extends JpaRepository<ContratVente, Long> {

    @Query(value = "SELECT sup FROM ContratVente sup WHERE sup.isSupprimer = false")
    List<ContratVente> findContratVenteBySupprimer(@Param("sup") boolean sup);
}
