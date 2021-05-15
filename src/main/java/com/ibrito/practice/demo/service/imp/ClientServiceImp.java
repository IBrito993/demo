package com.ibrito.practice.demo.service.imp;

import com.ibrito.practice.demo.dto.client.ClientFilter;
import com.ibrito.practice.demo.dto.client.ClientPageableRS;
import com.ibrito.practice.demo.dto.client.ClientRQ;
import com.ibrito.practice.demo.dto.client.ClientRS;
import com.ibrito.practice.demo.entity.ClientEntity;
import com.ibrito.practice.demo.exception.NotFoundException;
import com.ibrito.practice.demo.repository.ClientRepository;
import com.ibrito.practice.demo.service.ClientService;
import com.ibrito.practice.demo.utils.Converter;
import com.ibrito.practice.demo.utils.Util;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ClientServiceImp implements ClientService {

    @Autowired()
    ClientRepository clientRepository;

    @Override
    public ClientRS create(ClientRQ clientRQ) {

        ClientEntity clientEntity = Util.getStrictMapper().map(clientRQ, ClientEntity.class);
        clientEntity.setCreated_at( new Date());

        ClientEntity client = clientRepository
                .save(clientEntity);

        return Util.getStrictMapper().map(client, ClientRS.class);
    }

    @Override
    public ClientRS getById(UUID id) {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client not found"));

        return Util.getStrictMapper().map(client, ClientRS.class);
    }

    @Override
    public ClientPageableRS getAll(ClientFilter clientFilter) {

        Example<ClientEntity> customerExample = Example
                .of(ClientEntity.builder().address(clientFilter.getAddress())
                        .email(clientFilter.getEmail())
                        .name(clientFilter.getName()).phone(clientFilter.getPhone()).rut(clientFilter.getRut()).build(),
                        ExampleMatcher
                                .matchingAll().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase());

        Pageable paginator = Util.getPageable(clientFilter.getPage(), clientFilter.getSize());

        return getPageableRS(clientRepository.findAll(customerExample, paginator));
    }

    @Override
    public ClientRS update(UUID id, ClientRQ clientRQ) {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException( "Client with id " + id + " does not exists"));
        Converter.mapData(clientRQ, client);

        ClientEntity clientRS = clientRepository
                .save(client);

        return Util.getStrictMapper().map(clientRS, ClientRS.class);
    }

    @Override
    public void delete(UUID id) {
        if(!clientRepository.existsById(id)) {
            throw new NotFoundException(
                    "Client with id " + id + " does not exists");
        }
        clientRepository.deleteById(id);
    }

    private ClientPageableRS getPageableRS(Page<ClientEntity> page) {
        ClientPageableRS response = ClientPageableRS.builder()
                .data(page.getContent())
                .build();
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setCurrentPage(page.getNumber());

        return response;
    }
}
