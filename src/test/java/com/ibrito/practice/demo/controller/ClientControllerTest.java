package com.ibrito.practice.demo.controller;

import com.ibrito.practice.demo.dto.client.ClientRQ;
import com.ibrito.practice.demo.repository.ClientRepository;
import com.ibrito.practice.demo.service.ClientService;
import com.ibrito.practice.demo.service.imp.ClientServiceImp;
import com.ibrito.practice.demo.utils.UtilTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    @InjectMocks
    ClientController clientController;

    @Mock
    ClientServiceImp clientService;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    void create() throws Exception {
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/clients")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(UtilTest.asJsonString(ClientRQ.builder().address("address")
                                .email("mail@mail.com")
                                .name("name").phone("999999999").rut("12345698-0").build()));

        this.mockMvc.perform(builder).andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

}