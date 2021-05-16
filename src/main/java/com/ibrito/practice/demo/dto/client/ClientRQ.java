package com.ibrito.practice.demo.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRQ {

    @NotNull(message = "[name] cannot be null")
    @NotBlank(message = "[name] cannot be empty")
    String name;
    @NotNull(message = "[rut] cannot be null")
    @NotBlank(message = "[rut] cannot be empty")
    String rut;
    @NotNull(message = "[email] cannot be null")
    @NotBlank(message = "[email] cannot be empty")
    String email;

    String address;
    String phone;
}
