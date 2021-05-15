package com.ibrito.practice.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class ClientEntity {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "address", nullable = false)
    String address;
    @Column(name = "rut", nullable = false)
    String rut;
    @Column(name = "phone", nullable = false)
    String phone;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "created_at", nullable = false)
    Date created_at;


}
