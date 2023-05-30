package com.myPark.myPark.repository;

import com.myPark.myPark.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
    //Optional<Parking> findParkingByTelephoneAndMdp(String telephone, String mdp);
    @Query(value = "SELECT sup FROM Parking sup WHERE sup.isSupprimer = false")
    List<Parking> findParkingBySupprimer(@Param("sup") boolean sup);
}
