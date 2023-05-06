package com.intecap.hotel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "tour")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TourEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude // evita la recursividad infinita
    @EqualsAndHashCode.Exclude // evita la recursividad infinita
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "tour"
    )
    private Set<ReservationEntity> reservations;

    @ToString.Exclude // evita la recursividad infinita
    @EqualsAndHashCode.Exclude // evita la recursividad infinita
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "tour"
    )
    private Set<TicketEntity> tickets;


    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customer;


}
