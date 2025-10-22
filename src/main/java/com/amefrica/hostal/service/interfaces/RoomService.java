package com.amefrica.hostal.service.interfaces;

import com.amefrica.hostal.presentation.dto.reponse.RoomResponseDto;
import com.amefrica.hostal.presentation.dto.request.RoomRequestDto;

public interface RoomService {

   RoomResponseDto create(RoomRequestDto roomRequestDto);
}
