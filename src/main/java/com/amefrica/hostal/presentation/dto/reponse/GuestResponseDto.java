package com.amefrica.hostal.presentation.dto.reponse;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GuestResponseDto {


    private Integer id;
    private String name;
    private String lastname;
    private String cellphone;
    private String country;
    private Integer userId;

}
