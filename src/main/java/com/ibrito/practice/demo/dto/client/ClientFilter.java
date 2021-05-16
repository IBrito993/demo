package com.ibrito.practice.demo.dto.client;

import com.ibrito.practice.demo.dto.FilterBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientFilter extends FilterBase {
    String name;
    String rut;
    String email;
    String address;
    String phone;
}
