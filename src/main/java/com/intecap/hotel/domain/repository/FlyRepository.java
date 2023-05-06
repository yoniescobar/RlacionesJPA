package com.intecap.hotel.domain.repository;

import com.intecap.hotel.domain.entities.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository // Indica que es un repositorio de datos es opcional pero es buena practica
public interface FlyRepository extends JpaRepository<FlyEntity, Long> {
    //JPQL: Java Persistence Query Language: Lenguaje de consulta de persistencia de Java
    //Query Nativos: SQL: Structured Query Language: Lenguaje de consulta estructurado
    //Query JPARepository: Java Persistence API: Interfaz de programación de aplicaciones de persistencia de Java

    //JPQL
    @Query("SELECT f FROM fly  f WHERE f.price <:price")
    Set<FlyEntity> findByPriceLessThan(BigDecimal price);

    //Query Nativos SQL
    @Query(value = "SELECT * FROM fly WHERE price < :price", nativeQuery = true)
    Set<FlyEntity> findByPriceLessThanNative(BigDecimal price);

    //Query Join vuelos y tickets JPQL: Java Persistence Query Language: Lenguaje de consulta de persistencia de Java
    //vuelo correspondiente al ticket
    //JPQL se recomenda utilizarlo
    @Query("SELECT f FROM fly f JOIN FETCH f.tickets t  WHERE t.id = :id")
    Optional<FlyEntity> findByIdJoinFetchTickets(UUID id);





}
