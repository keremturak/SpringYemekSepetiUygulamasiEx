package com.keremturak.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductSaveRequestDto {
    @NotNull
    Long restaurantid;
    @NotEmpty
    String name;
    String category;
    @NotNull
    Double cost;
}
