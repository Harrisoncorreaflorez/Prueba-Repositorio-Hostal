package com.amefrica.hostal.util.mapper;

import com.amefrica.hostal.persistence.entity.RoleEntity;
import com.amefrica.hostal.persistence.entity.RoleEnum;
import com.amefrica.hostal.persistence.entity.UserEntity;
import com.amefrica.hostal.presentation.dto.request.UserRequestDto;
import com.amefrica.hostal.presentation.dto.reponse.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity toEntity(UserRequestDto dto) {


       return UserEntity.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .accountNonLocked(true)       // ✅ Cuenta no bloqueada
                .accountNonExpired(true)      // ✅ Cuenta no expirada
                .credentialNonExpired(true)  // ✅ Contraseña no expirada
               .isEnabled(true)                // ✅ Usuario habilitado
                .build();


    }

    public UserResponseDto toResponse(UserEntity entity) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());


         Set<String> roleNames= entity.getRoleEntities().stream()
                .map(role -> role.getRoleEnum().name())
                .collect(Collectors.toSet());

         dto.setRoles(roleNames);


        return dto;
    }

    public UserResponseDto toResponse(UserEntity entity, String token) {
        UserResponseDto dto = toResponse(entity);
        dto.setToken(token);
        return dto;
    }
}
