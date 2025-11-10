package com.amefrica.hostal.service.implementation;

import com.amefrica.hostal.configuration.security.JwtUtils;
import com.amefrica.hostal.presentation.dto.reponse.AuthResponse;
import com.amefrica.hostal.presentation.dto.reponse.GuestResponseDto;
import com.amefrica.hostal.presentation.dto.reponse.UserResponseDto;
import com.amefrica.hostal.presentation.dto.request.GuestRequestDto;
import com.amefrica.hostal.presentation.dto.request.LoginRequestDto;
import com.amefrica.hostal.presentation.dto.request.RegisterDto;
import com.amefrica.hostal.presentation.dto.request.UserRequestDto;
import com.amefrica.hostal.service.interfaces.AuthenticationService;
import com.amefrica.hostal.service.interfaces.GuestService;
import com.amefrica.hostal.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    private final  AuthenticationManager authenticationManager;

    private final UserService userService;

    private final JwtUtils jwtUtils;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                                     UserService userService,
                                     JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public UserResponseDto register(UserRequestDto userRequestDto) {
        return  userService.save(userRequestDto);
    }
    @Override
    public AuthResponse login(LoginRequestDto loginRequestDto) {
        try {
            //  Autenticación
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDto.getEmail(),
                            loginRequestDto.getPassword()
                    )
            );

            // Guardar en SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);


            // Retornar AuthResponse
            return AuthResponse.builder()
                    .email(loginRequestDto.getEmail())
                    .message("Authentication was successful")
                    .token(this.jwtUtils.createToken(authentication))
                    .build();

        } catch (Exception ex) {

            return AuthResponse.builder()
                    .email(loginRequestDto.getEmail())
                    .message("Authentication failed: " + ex.getMessage())
                    .token(null)
                    .build();
        }
    }
}
