package com.amefrica.hostal.presentation.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class GuestRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String cellphone;
    @NotBlank
    private String  country;
    private Integer userId;
}
