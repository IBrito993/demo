package com.ibrito.practice.demo.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRS {

    UUID id;
    @NotBlank
    @NotNull
    String name;
    @NotBlank
    @NotNull
    String rut;
    @NotBlank
    @NotNull
    String email;

    String address;
    String phone;


}
