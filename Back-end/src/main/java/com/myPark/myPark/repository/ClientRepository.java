package com.myPark.myPark.repository;

import com.myPark.myPark.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByTelephoneAndMdp(String telephone, String mdp);
    @Query(value = "SELECT sup FROM Client sup WHERE sup.isSupprimer = false")
    List<Client> findClientBySupprimer(@Param("sup") boolean sup);
}
