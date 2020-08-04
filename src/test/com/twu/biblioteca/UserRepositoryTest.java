package com.twu.biblioteca;

import com.twu.biblioteca.entities.User;
import com.twu.biblioteca.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserRepositoryTest {

    private UserRepository userRepository = new UserRepository();

    private User testUser = new User("user-001", "password1");

    @Before
    public void addUser() {
        userRepository.addUser(testUser);
    }

    @Test
    public void should_have_user_when_we_add_users() {
        assertTrue(userRepository.getUsers().contains(testUser));
    }

    @Test
    public void should_login_when_enter_right_message() {
        assertEquals(userRepository.isLogin("user-001", "password1"), true);
    }
}
