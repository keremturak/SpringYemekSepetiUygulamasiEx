package com.keremturak.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class OrderCreateOrderRequestDto {

    @NotNull
    Long customerid;
    @NotNull
    Long productid;

    LocalDate date;
}
