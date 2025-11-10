package com.amefrica.hostal.service.implementation;

import com.amefrica.hostal.persistence.entity.UserEntity;
import com.amefrica.hostal.persistence.repository.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(()->new
                UsernameNotFoundException("The user " + username + "doesn't exist"));

        /*
        * convert user roles into SimpleGrantedAuthority objects
        * so that spring security can handle them as permissions.
         */
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoleEntities()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().toString()))));




        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialNonExpired(),
                userEntity.isAccountNonExpired(),authorityList
        );


        /*
        Implementar UserDetailsService para cargar los detalles y roles de usuario para la autenticación.
         */



    }
}
