package com.devmind.springapp.homeworkc16.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public class LoginInResponse {

    private String firstName;

    private String lastName;

    @NotNull(message = "email must be not-null")
    @Email
    private String email;
}
