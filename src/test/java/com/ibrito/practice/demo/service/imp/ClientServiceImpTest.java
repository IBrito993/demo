package com.ibrito.practice.demo.service.imp;

import com.ibrito.practice.demo.dto.client.ClientFilter;
import com.ibrito.practice.demo.dto.client.ClientPageableRS;
import com.ibrito.practice.demo.dto.client.ClientRQ;
import com.ibrito.practice.demo.entity.ClientEntity;
import com.ibrito.practice.demo.repository.ClientRepository;
import com.ibrito.practice.demo.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientServiceImpTest {

    @Mock
    private ClientRepository clientRepository;


    private ClientService clientService ; // underTest

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientServiceImp(clientRepository);
    }

    @Test
    void canCreateClient() {
        ClientEntity client = ClientEntity.builder().address("address")
                .created_at(new Date()).email("mail@mail.com")
                .name("name").phone("999999999").rut("12345698-0").build();

        clientService.create(client);

        ArgumentCaptor<ClientEntity> clientArgumentCaptor =
                ArgumentCaptor.forClass(ClientEntity.class);

        verify(clientRepository)
                .save(clientArgumentCaptor.capture());

        ClientEntity capturedClient = clientArgumentCaptor.getValue();

        assertThat(capturedClient).isEqualTo(client);

    }

    @ParameterizedTest()
    @ValueSource(strings = "991c31e2-43b7-4a44-b29d-698b9da6f6fa")
    void canGetClientById(UUID id) {
        ClientEntity client = ClientEntity.builder().address("address")
                .created_at(new Date()).email("mail@mail.com")
                .name("name").phone("999999999").rut("12345698-0").build();

        Mockito.when(clientRepository.findById(id)).thenReturn(Optional.of(client));

        ClientEntity clientRS = clientService.getById(id);

        assertEquals(client.getName(), clientRS.getName());
    }

    @Test
    void canGetAllClients() {

        List<ClientEntity> customers = Arrays
                .asList(ClientEntity.builder().address("address")
                        .created_at(new Date()).email("mail@mail.com")
                        .name("name").phone("999999999").rut("12345698-0")
                        .build());
        Page<ClientEntity> customerPage = new PageImpl(customers);

        Mockito
                .when(clientRepository.findAll(Mockito.any(Example.class), Mockito.any(Pageable.class)))
                .thenReturn(customerPage);

        ClientPageableRS response = clientService
                .getAll(ClientFilter.builder().name("Client").build());
        assertNotNull(response.getData());
    }

    @ParameterizedTest()
    @ValueSource(strings = "991c31e2-43b7-4a44-b29d-698b9da6f6fa")
    void canUpdateClient(UUID id) {
        ClientEntity client = ClientEntity.builder().address("address")
                .created_at(new Date()).email("mail@mail.com")
                .name("name").phone("999999999").rut("12345698-0").build();

        ClientRQ clientRQ = ClientRQ.builder().address("address")
                .email("mail@mail.com")
                .name("name").phone("999999999").rut("12345698-0").build();

        Mockito.when(clientRepository.findById(id)).thenReturn(Optional.of(client));
        Mockito.when(clientRepository.save(Mockito.any())).thenReturn(client);


        assertNotNull(clientService.update(id, clientRQ));
    }

    @ParameterizedTest()
    @ValueSource(strings = "991c31e2-43b7-4a44-b29d-698b9da6f6fa")
    void canDeleteClient(UUID id) {
        given(clientRepository.existsById(id))
                .willReturn(true);
        // when
        clientService.delete(id);

        // then
        verify(clientRepository).deleteById(id);
    }
}