package com.myPark.myPark.repository;

import com.myPark.myPark.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query(value = "SELECT sup FROM Facture sup WHERE sup.isSupprimer = false")
    List<Facture> findFactureBySupprimer(@Param("sup") boolean sup);
}
