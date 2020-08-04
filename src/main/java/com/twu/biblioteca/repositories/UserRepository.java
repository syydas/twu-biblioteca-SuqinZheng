package com.twu.biblioteca.repositories;

import com.twu.biblioteca.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public Boolean isLogin(String id, String password) {
        User user = this.getUserById(id);
        if (user == null ) {
            System.out.println("Sorry that's not a valid Id");
            return false;
        } else if (!user.getPassword().equals(password)) {
            System.out.println("Sorry that's not a valid password");
            return false;
        }
        return true;
    }
}
