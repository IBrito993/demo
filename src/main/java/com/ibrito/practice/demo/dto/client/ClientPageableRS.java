package com.ibrito.practice.demo.dto.client;


import com.ibrito.practice.demo.dto.PageableBaseRS;
import com.ibrito.practice.demo.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientPageableRS  extends PageableBaseRS {

    List<ClientEntity> data;
}
