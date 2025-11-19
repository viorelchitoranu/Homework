package com.devmind.springapp.homeworkc16.controllers;


import com.devmind.springapp.homeworkc16.dto.LogInReq;
import com.devmind.springapp.homeworkc16.dto.LoginInResponse;
import com.devmind.springapp.homeworkc16.dto.User;
import com.devmind.springapp.homeworkc16.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.NullValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User userRequest) {


        if (userRequest.getEmail() == null || userRequest.getEmail().isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email este obligatoriu");
        }


        if (userService.getUserByEmail(userRequest.getEmail()) != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("email deja folosit");
        }


        User saved = userService.registerUser(userRequest);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }


    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/auth_users")
    public ResponseEntity<?> getAuthUsers() {
        return ResponseEntity.ok(userService.getAuthUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIN( @RequestBody LogInReq logInReq) {

        if (logInReq.getEmail() == null || logInReq.getEmail().isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email este obligatoriu");
        }

        if (logInReq.getPassword() == null || logInReq.getPassword().isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Parola este obligatorie");
        }

        User user = userService.findUserByEmailPass(logInReq.getEmail(), logInReq.getPassword());


        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email sau parola incorecte");
        }

        if (userService.isUserAuthenticated(user)) {
            LoginInResponse loginInResponse = new LoginInResponse(
                    user.getFirstName(), user.getLastName(), user.getEmail());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginInResponse);

        }

        userService.addAuthUser(user);
        LoginInResponse loginInResponse = new LoginInResponse(
                user.getFirstName(), user.getLastName(), user.getEmail());


        return ResponseEntity.ok(loginInResponse);

    }

    @PostMapping("/logout/{email}")
    public ResponseEntity<?> logout( @PathVariable String email) {
        if (email == null || email.isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email este obligatoriu");
        }

        if(!userService.isEmailAuth(email)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Utilizatorul cu acest email nu este autentificat");
        }

        userService.logoutByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body("Logout realizat cu succes");

    }


}
