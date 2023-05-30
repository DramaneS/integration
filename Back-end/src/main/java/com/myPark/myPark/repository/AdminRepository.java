package com.myPark.myPark.repository;

import com.myPark.myPark.model.Admin;
import com.myPark.myPark.model.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByTelephoneAndMdp(String telephone, String mdp);
    @Query(value = "SELECT sup FROM Admin sup WHERE sup.isSupprimer = false")
    List<Admin> findAdminBySupprimer(@Param("sup") boolean sup);
}
