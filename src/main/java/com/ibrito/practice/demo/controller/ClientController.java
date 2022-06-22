package com.ibrito.practice.demo.controller;


import com.ibrito.practice.demo.dto.client.ClientFilter;
import com.ibrito.practice.demo.dto.client.ClientPageableRS;
import com.ibrito.practice.demo.dto.client.ClientRQ;
import com.ibrito.practice.demo.dto.client.ClientRS;
import com.ibrito.practice.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = {"*"})
@Slf4j
@RequiredArgsConstructor
public class ClientController {


    private final ClientService clientService;


    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClientRS> create(@Valid @RequestBody ClientRQ client) {

        ClientRS promiseResponse = clientService
                .create(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(promiseResponse);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClientPageableRS> getAll(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) String rut,
                                                   @Valid ClientFilter clientRQ) {

        ClientPageableRS promiseResponse = clientService.getAll(clientRQ);

        return ResponseEntity.status(HttpStatus.OK).body(promiseResponse);
    }

    @GetMapping(value = "/{clientId}", produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClientRS> getById(@PathVariable(name = "clientId") UUID id) {

        ClientRS promiseResponse = clientService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(promiseResponse);
    }


}
