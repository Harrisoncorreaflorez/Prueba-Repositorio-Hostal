package com.amefrica.hostal.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Column(name = "room_number",nullable = false)
    private int roomNumber;

   @Column(name = "capacity", nullable = false)
   private int capacity;

   @Column(name = "price",nullable = false)
   private double price;



}
