package com.devmind.springapp.rest_demo.controllers;


import com.devmind.springapp.rest_demo.dtos.MessageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @GetMapping("/messages")
    public ResponseEntity<String> messageInfo(){
        String html = """
        <html>
          <body>
            <h1>Cerinta 4 a exercitiului status Postman pentru /messages</h1>
            <p>Request cu 201:</p>
            <img src="/status201.jpg" alt="POST 201" />
            <p>Request cu 401:</p>
            <img src="/status401.jpg" alt="POST 401" />
          </body>
        </html>
        """;

        return ResponseEntity.ok(html);
    }

    @PostMapping("/messages")
    public ResponseEntity<Void> createMessage(
            @RequestHeader(value = "authentication", required = false) String authenticationHeader,
            @RequestBody MessageRequest messageRequest
    ) {
        if("devmind-api-key".equals(authenticationHeader)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }



}
