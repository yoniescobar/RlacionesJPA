package com.intecap.hotel.domain.repository;

import com.intecap.hotel.domain.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository // Indica que es un repositorio de datos es opcional pero es buena practica
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {


}
