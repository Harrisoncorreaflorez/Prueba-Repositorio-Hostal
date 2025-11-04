package com.amefrica.hostal.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "guests")
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "lastname",nullable = false)
    private String lastname;


    @Column(name = "cellphone",nullable = false,unique = true)
    private String cellphone;

    @Column(name = "country",nullable = false)
    private String  country;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false, unique = true)
    private UserEntity userEntity;



}
