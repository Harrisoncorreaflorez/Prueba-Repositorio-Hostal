package com.amefrica.hostal.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {



    @GetMapping
    public ResponseEntity<?>listAll(){

       return  ResponseEntity.ok("reservations..");
    }
}
