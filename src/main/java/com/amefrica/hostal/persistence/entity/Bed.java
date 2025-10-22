package com.amefrica.hostal.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "beds")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBed;

    @Column(name = "num_room", nullable = false)
    private int numRoom;

    @Column(name = "num_bed", nullable = false)
    private int numBed;

}
