package com.examensarbet.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void register_success() {
        UserService service = new UserService();

        service.registerUser("test@test.com", "123");
        assertTrue(service.login("test@test.com", "123"));    }

    @Test
    void register_fail_invalidEmail() {
        UserService service = new UserService();

        assertFalse(service.registerUser("dåligEmail", "123"));

    }

    @Test
    void login_fail() {
        UserService service = new UserService();

        service.registerUser("test@test.com", "123");

        assertFalse(service.login("test@test.com", "wrong"));
    }
}