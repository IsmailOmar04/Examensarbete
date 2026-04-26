package com.examensarbet.demo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public boolean registerUser(String email, String password) {

        if (email == null || !email.contains("@")) {
            return false;
        }

        if (password == null || password.length() < 3) {
            return false;
        }

        users.add(new User(email, password));
        return true;
    }

    public boolean login(String email, String password) {
        return users.stream()
                .anyMatch(u ->
                        u.getEmail().equals(email) &&
                                u.getPassword().equals(password)
                );
    }
}