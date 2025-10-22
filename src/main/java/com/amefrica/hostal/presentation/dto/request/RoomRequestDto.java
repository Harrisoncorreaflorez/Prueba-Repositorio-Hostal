package com.amefrica.hostal.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomRequestDto {

    @NotNull(message = "El numero de la habitacion no puede ser nullo")
    private int number;
    @NotNull(message = "La capacidad no puede ser nullo")
    private int capacity;
    private double price;
}
