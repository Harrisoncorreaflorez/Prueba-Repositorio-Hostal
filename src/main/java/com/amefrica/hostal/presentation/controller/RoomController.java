package com.amefrica.hostal.presentation.controller;

import com.amefrica.hostal.presentation.dto.request.RoomRequestDto;
import com.amefrica.hostal.service.interfaces.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {


    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RoomRequestDto roomRequestDto){

        ResponseEntity.ok(roomService.create(roomRequestDto));
    }
}
