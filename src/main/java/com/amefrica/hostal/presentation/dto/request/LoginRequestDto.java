package com.amefrica.hostal.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class LoginRequestDto {

    @Email
   private String email;
    @NotBlank
   private String password;

}
