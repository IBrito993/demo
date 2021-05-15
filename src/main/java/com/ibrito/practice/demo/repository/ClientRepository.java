package com.ibrito.practice.demo.repository;

import com.ibrito.practice.demo.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ClientRepository  extends JpaRepository<ClientEntity, UUID> {
}
