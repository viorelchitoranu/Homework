package com.devmind.springapp.homeworkc16.services;

import com.devmind.springapp.homeworkc16.dto.User;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class UserService {

    private final List<User> users = new ArrayList<>();
    private final List<User> authUsers = new ArrayList<>();
    private int currentID = 1;


    public User registerUser(User user) {
        user.setId(currentID++);
        users.add(user);
        return user;
    }



    public User getUserByEmail(String email) {
        return users.stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public User findUserByEmailPass(String email, String password) {
        return users.stream()
                .filter(u -> email.equals(u.getEmail()) &&
                        password.equals(u.getPassword()))
                .findFirst()
                .orElse(null);
    }

    public void addAuthUser(User user) {
        authUsers.add(user);
    }

    public List<User> getAuthUser() {
        return authUsers;
    }

    public boolean isUserAuthenticated(User user) {
        return authUsers.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()));

    }

    public boolean isEmailAuth (String email) {
        return authUsers.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    public void logoutByEmail(String email) {
        authUsers.removeIf(u -> u.getEmail().equals(email));
    }


}
