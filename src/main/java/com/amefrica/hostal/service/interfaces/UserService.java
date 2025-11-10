package com.amefrica.hostal.service.interfaces;

import com.amefrica.hostal.presentation.dto.reponse.UserResponseDto;
import com.amefrica.hostal.presentation.dto.request.UserRequestDto;

public interface UserService  {

  UserResponseDto save(UserRequestDto userRequestDto);

}
