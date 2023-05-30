package com.myPark.myPark.repository;

import com.myPark.myPark.model.ContratLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratLocationRepository extends JpaRepository<ContratLocation, Long> {
    @Query(value = "SELECT sup FROM ContratLocation sup WHERE sup.isSupprimer = false")
    List<ContratLocation> findContratLocationBySupprimer(@Param("sup") boolean sup);
}
