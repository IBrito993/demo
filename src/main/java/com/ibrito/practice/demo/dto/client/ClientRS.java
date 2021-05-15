package com.ibrito.practice.demo.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
