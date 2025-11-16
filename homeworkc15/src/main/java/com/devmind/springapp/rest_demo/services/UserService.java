package com.devmind.springapp.rest_demo.services;


import com.devmind.springapp.rest_demo.dtos.User;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static int TECHNICAL_ID = 0;

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(++TECHNICAL_ID, "John1", "Doe1"));
        users.add(new User(++TECHNICAL_ID, "John2", "Doe2"));
        users.add(new User(++TECHNICAL_ID, "John3", "Doe3"));
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    public Optional<User> createUser(User user) {
        if (StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getSurname())) {

            User newUser = new User(++TECHNICAL_ID, user.getName(), user.getSurname());

            users.add(newUser);
            return Optional.of(newUser);
        }

        return Optional.empty();
    }

}
