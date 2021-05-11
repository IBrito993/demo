package com.ibrito.practice.demo.dto.client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

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
