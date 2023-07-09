package com.keremturak.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegisterResponseDto {
    Long id;
    String name;
    String surname;
    String email;
    Long balance;
    int status ;
}
