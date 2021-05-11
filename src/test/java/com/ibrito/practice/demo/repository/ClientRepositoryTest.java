package com.ibrito.practice.demo.repository;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientRepositoryTest {
    @Autowired
    private ClientRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

}