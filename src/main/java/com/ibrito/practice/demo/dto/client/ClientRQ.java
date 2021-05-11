package com.ibrito.practice.demo.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRQ {

    @NotNull(message = "[name] cannot be null")
    @NotBlank(message = "[name] cannot be empty")
    String name;
    @NotNull(message = "[name] cannot be null")
    @NotBlank(message = "[name] cannot be empty")
    String rut;
    @NotNull(message = "[name] cannot be null")
    @NotBlank(message = "[name] cannot be empty")
    String email;

    String address;
    String phone;
}
