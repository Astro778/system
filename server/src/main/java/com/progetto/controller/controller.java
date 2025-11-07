package com.progetto.controller;

import com.progetto.server.UserService;
import com.progetto.model.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController{
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //Using the GET method to retrieve user information by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully" + user.GetUsername();
    }

    //DELETE: delete user by ID
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean removed = userService.removeUser(id);
        return removed ? "User deleted successfully" : "User not found";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        boolean updated = userService.updateUser(id, user);
        return updated ? "User updated successfully" : "User not found";
    }

}

