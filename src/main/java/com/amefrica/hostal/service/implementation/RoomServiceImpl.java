package com.amefrica.hostal.service.implementation;

import com.amefrica.hostal.persistence.repository.RoomRepository;
import com.amefrica.hostal.presentation.dto.reponse.RoomResponseDto;
import com.amefrica.hostal.presentation.dto.request.RoomRequestDto;
import com.amefrica.hostal.service.interfaces.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl  implements RoomService {


    private RoomRepository repository;

    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomResponseDto create(RoomRequestDto roomRequestDto) {

        repository.save(RoomMapper(roomRequestDto));

        return null;
    }
}
