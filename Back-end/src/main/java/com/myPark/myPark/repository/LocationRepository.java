package com.myPark.myPark.repository;

import com.myPark.myPark.model.Chauffeur;
import com.myPark.myPark.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(value = "SELECT sup FROM Location sup WHERE sup.isSupprimer = false")
    List<Location> findLocationBySupprimer(@Param("sup") boolean sup);
}
