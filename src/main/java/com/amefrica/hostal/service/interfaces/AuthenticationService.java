package com.amefrica.hostal.service.interfaces;

import com.amefrica.hostal.presentation.dto.reponse.AuthResponse;
import com.amefrica.hostal.presentation.dto.reponse.UserResponseDto;
import com.amefrica.hostal.presentation.dto.request.LoginRequestDto;
import com.amefrica.hostal.presentation.dto.request.RegisterDto;
import com.amefrica.hostal.presentation.dto.request.UserRequestDto;

public interface AuthenticationService {


    UserResponseDto register(UserRequestDto userRequestDto);
    AuthResponse login(LoginRequestDto loginRequestDto);

}
