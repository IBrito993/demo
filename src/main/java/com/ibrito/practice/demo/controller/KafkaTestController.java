package com.ibrito.practice.demo.controller;


import com.ibrito.practice.demo.config.kafka.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class KafkaTestController {

    private final Producer producer;

    @PostMapping
    public ResponseEntity<String> sendMsg() {

        producer.sendMessage("Message Sent");
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

}
