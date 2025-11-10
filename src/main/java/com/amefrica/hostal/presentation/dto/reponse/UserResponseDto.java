package com.amefrica.hostal.presentation.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserResponseDto {

   private Integer id;
   private String email;
   private Set<String> roles;
   private String token;

}
