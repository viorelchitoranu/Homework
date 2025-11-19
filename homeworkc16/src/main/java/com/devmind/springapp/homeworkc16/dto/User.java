package com.devmind.springapp.homeworkc16.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private int id;

    @NotBlank(message = "firstName must be a non-empty string")
    private String firstName;

    @NotBlank(message = "lastName must be a non-empty string")
    private String lastName;

    @NotNull(message = "email must be not-null")
    @Email
    private String email;

//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,20}$",
//            message = "password must have digit + lowercase + uppercase + symbol")
    private String password;
}
