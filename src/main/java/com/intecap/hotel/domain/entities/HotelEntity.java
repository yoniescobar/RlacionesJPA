package com.intecap.hotel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "hotel")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder // evita la sobrecarga de constructores y getters and setters (lombok)
public class HotelEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String address;
    private Integer rating;
    private BigDecimal price;

    @ToString.Exclude // evita la recursividad infinita
    @EqualsAndHashCode.Exclude // evita la recursividad infinita

    @OneToMany(
            cascade = CascadeType.ALL, // si se elimina el vuelo se eliminan todos los tickets
            fetch = FetchType.EAGER, // no se cargan los tickets hasta que se llame al getter
            orphanRemoval = true, // si se elimina un ticket huerfano (sin vuelo) se elimina de la base de datos
            mappedBy = "hotel"
    ) // un vuelo puede tener muchos tickets (plural)
    private Set<ReservationEntity> reservation; // un vuelo puede tener muchos tickets (plural) set para mapear la relacion de uno a muchos

}
