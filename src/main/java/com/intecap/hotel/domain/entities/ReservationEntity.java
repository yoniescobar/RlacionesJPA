package com.intecap.hotel.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReservationEntity implements Serializable {
    @Id
    private UUID id; // UUID: Universally Unique Identifier (java.util)
    @Column(name = "date_reservation")
    private LocalDateTime dateTimeReservation; // LocalDateTime: fecha y hora (java.time)
    private LocalDate dateStart;  // LocalDate: fecha (java.time)
    private LocalDate dateEnd;
    private Integer totalDays;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @ManyToOne
    @JoinColumn(name = "tour_id") // nullable = true: no es obligatorio
    private TourEntity tour;

    @ManyToOne
    @JoinColumn(name = "customer_id") // nullable = true: no es obligatorio
    private CustomerEntity customer;

}
