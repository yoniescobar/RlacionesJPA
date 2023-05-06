package com.intecap.hotel.domain.repository;

import com.intecap.hotel.domain.entities.FlyEntity;
import com.intecap.hotel.domain.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // Indica que es un repositorio de datos es opcional pero es buena practica
public interface ReservationRepository extends JpaRepository<ReservationEntity, UUID> {
}
