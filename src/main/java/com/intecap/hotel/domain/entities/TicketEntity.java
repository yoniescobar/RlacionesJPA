package com.intecap.hotel.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketEntity implements Serializable {
    @Id
    private UUID id;
    private LocalDate departureDate; // departureDate: fecha de salida
    private LocalDate arrivalDate; // arrivalDate: fecha de llegada
    private LocalDate purchaseDate; // purchaseDate: fecha de compra
    private BigDecimal price; // price: precio

    @ManyToOne // muchos tickets pueden tener un solo vuelo (singular)
    @JoinColumn(name = "fly_id") // nombre de la columna que hace referencia a la tabla fly
    private FlyEntity fly; // un ticket puede tener un solo vuelo (singular)

    @ManyToOne
    @JoinColumn(name = "tour_id") // ..nullable = true: no es obligatorio
    private TourEntity tour;

    @ManyToOne
    @JoinColumn(name = "customer_id") // nullable = true: no es obligatorio
    private CustomerEntity customer;
}
