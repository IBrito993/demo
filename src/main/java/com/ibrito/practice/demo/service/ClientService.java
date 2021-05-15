package com.ibrito.practice.demo.service;

import com.ibrito.practice.demo.dto.client.ClientFilter;
import com.ibrito.practice.demo.dto.client.ClientPageableRS;
import com.ibrito.practice.demo.dto.client.ClientRQ;
import com.ibrito.practice.demo.dto.client.ClientRS;
import com.ibrito.practice.demo.entity.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface ClientService{
    ClientRS create(ClientRQ client);

    ClientEntity getById(UUID id);

    ClientPageableRS getAll(ClientFilter clientFilter);

    ClientEntity update(UUID id, ClientRQ clientRQ);

    void delete(UUID id);


}
