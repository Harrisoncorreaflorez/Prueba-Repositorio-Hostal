package com.amefrica.hostal.presentation.dto.request;

import jakarta.validation.Valid;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RegisterDto {

    // user
    @Valid
   private UserRequestDto userRequestDto;

   // guest
    @Valid
    private GuestRequestDto guestRequestDto;


}
