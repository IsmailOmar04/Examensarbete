package com.examensarbet.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDTO user) {

        boolean success = userService.registerUser(user.email, user.password);

        if (success) return "Registrerad!";
        return "Fel input";
    }


    @GetMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        boolean success = userService.login(email, password);

        if (success) {
            return "YEEEEEEY";
        } else {
            return "FEEEEEEEL";
        }
    }
}