package com.amefrica.hostal.service.implementation;

import com.amefrica.hostal.persistence.entity.RoleEntity;
import com.amefrica.hostal.persistence.entity.RoleEnum;
import com.amefrica.hostal.persistence.entity.UserEntity;
import com.amefrica.hostal.persistence.repository.RoleRepository;
import com.amefrica.hostal.persistence.repository.UserRepository;
import com.amefrica.hostal.presentation.dto.reponse.UserResponseDto;
import com.amefrica.hostal.presentation.dto.request.UserRequestDto;
import com.amefrica.hostal.service.interfaces.UserService;
import com.amefrica.hostal.util.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

   private final UserMapper userMapper;

   private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

   @Transactional
    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        UserEntity userEntity= userMapper.toEntity(userRequestDto);
        UserEntity userSaved= userRepository.save(userEntity);

       RoleEntity roleEntity = roleRepository.findByRoleEnum(RoleEnum.GUEST).get();
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(roleEntity);
        userSaved.setRoleEntities(roleEntities);

       System.out.println("Roles entity : " + roleEntity.getRoleEnum().name());


        return userMapper.toResponse(userSaved);
    }

}
