package com.amefrica.hostal.service.interfaces;

import com.amefrica.hostal.presentation.dto.reponse.GuestResponseDto;
import com.amefrica.hostal.presentation.dto.request.GuestRequestDto;

public interface GuestService {

    GuestResponseDto create(GuestRequestDto guestRequestDto);
}
