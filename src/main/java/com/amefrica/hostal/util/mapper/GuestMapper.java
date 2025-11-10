package com.amefrica.hostal.util.mapper;

import com.amefrica.hostal.persistence.entity.GuestEntity;
import com.amefrica.hostal.presentation.dto.reponse.GuestResponseDto;
import com.amefrica.hostal.presentation.dto.request.GuestRequestDto;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper {

    public GuestEntity toEntity(GuestRequestDto dto) {
        GuestEntity entity = new GuestEntity();
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setCellphone(dto.getCellphone());
        entity.setCountry(dto.getCountry());
        return entity;
    }

    public GuestResponseDto toResponse(GuestEntity entity) {
        GuestResponseDto dto = new GuestResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastname(entity.getLastname());
        dto.setCellphone(entity.getCellphone());
        dto.setCountry(entity.getCountry());
        return dto;
    }
}