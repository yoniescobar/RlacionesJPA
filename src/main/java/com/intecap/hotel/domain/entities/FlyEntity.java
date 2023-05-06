package com.intecap.hotel.domain.entities;

import com.intecap.hotel.util.AeroLine;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;


@Entity(name = "fly")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlyEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private Double destinyLng;
    @Column(length = 20)
    private String originName;
    @Column(length = 20)
    private String destinyName;
    private BigDecimal price;

    @Enumerated(EnumType.STRING) // esto es para que se guarde el nombre del enum en la base de datos
    private AeroLine aeroLine; // aero_gold, blue_sky (enum)


    @ToString.Exclude // evita la recursividad infinita
    @EqualsAndHashCode.Exclude // evita la recursividad infinita
    @OneToMany(
            cascade = CascadeType.ALL, // si se elimina el vuelo se eliminan todos los tickets
            fetch = FetchType.EAGER, // carga los tickets al momento de cargar el vuelo
            orphanRemoval = true, // si se elimina un ticket huerfano (sin vuelo) se elimina de la base de datos
            mappedBy = "fly" // el nombre de la variable en la clase TicketEntity
    ) // un vuelo puede tener muchos tickets (plural)
    private Set<TicketEntity> tickets; // un vuelo puede tener muchos tickets (plural) set para mapear la relacion de uno a muchos

}
