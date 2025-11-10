package com.amefrica.hostal.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity

    public class SecurityConfig {


    @Autowired
      private JwtUtils jwtUtils;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http
                    .csrf(csrf -> csrf.disable())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(auth -> auth

                            //publics routes
                            .requestMatchers(HttpMethod.POST, "/api/v1/auth/**").permitAll()

                            // privates routes

                            .requestMatchers(HttpMethod.GET,"/api/v1/reservations").hasRole("GUEST")

                            .anyRequest().denyAll()
                    )
                    .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                    .build();
        }


        @Bean
        public AuthenticationManager authenticationManager(HttpSecurity http ,
                                                           PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception {

            AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
            builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

            return builder.build();

        }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
    }




