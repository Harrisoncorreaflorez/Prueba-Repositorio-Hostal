package com.amefrica.hostal.service.implementation;

import com.amefrica.hostal.persistence.entity.GuestEntity;
import com.amefrica.hostal.persistence.entity.UserEntity;
import com.amefrica.hostal.persistence.repository.GuestRepository;
import com.amefrica.hostal.persistence.repository.UserRepository;
import com.amefrica.hostal.presentation.dto.reponse.GuestResponseDto;
import com.amefrica.hostal.presentation.dto.request.GuestRequestDto;
import com.amefrica.hostal.service.interfaces.GuestService;
import com.amefrica.hostal.util.mapper.GuestMapper;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {


    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    private final UserRepository userRepository;

    public GuestServiceImpl(GuestRepository guestRepository, GuestMapper guestMapper, UserRepository userRepository) {
        this.guestRepository = guestRepository;
        this.guestMapper = guestMapper;
        this.userRepository = userRepository;
    }

    @Override
    public GuestResponseDto create(GuestRequestDto guestRequestDto) {

        UserEntity user = userRepository.findById(guestRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));


        GuestEntity guestEntity = guestMapper.toEntity(guestRequestDto);
        guestEntity.setUserEntity(user);

        GuestEntity guestSaved= guestRepository.save(guestEntity);

        return guestMapper.toResponse(guestSaved);
    }
}
