package com.intecap.hotel.domain.repository;

import com.intecap.hotel.domain.entities.CustomerEntity;
import com.intecap.hotel.domain.entities.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que es un repositorio de datos es opcional pero es buena practica
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
