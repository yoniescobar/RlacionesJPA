package com.intecap.hotel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerEntity {
    @Id
    private String dni;
    @Column(length = 50)
    private String fullName;
    @Column(length = 20)
    private String creditCard;
    @Column(length = 12)
    private String phoneNumber;
    private Integer totalFlights;
    private Integer totalLodgings; // lodgings: alojamientos
    private Integer totalTours;

    @ToString.Exclude // evita la recursividad infinita
    @EqualsAndHashCode.Exclude // evita la recursividad infinita
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer"
    )
    private Set<TicketEntity> tickets;

    @ToString.Exclude // evita la recursividad infinita
    @EqualsAndHashCode.Exclude // evita la recursividad infinita
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer"
    )
    private Set<ReservationEntity> reservations;


    @ToString.Exclude // evita la recursividad infinita
    @EqualsAndHashCode.Exclude // evita la recursividad infinita
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer"
    )
    private Set<TourEntity> tours;

}
