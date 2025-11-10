package com.amefrica.hostal.presentation.dto.reponse;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AuthResponse {

    private String email;
    private String message;
    private String token;
}
