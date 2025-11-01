package com.amefrica.hostal.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms_type")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

}
