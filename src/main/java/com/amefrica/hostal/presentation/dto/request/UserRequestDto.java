package com.amefrica.hostal.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class UserRequestDto {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
}
