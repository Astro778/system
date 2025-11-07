package com.progetto.controller;

import com.progetto.service.UserService;
import com.progetto.model.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController{
    /*
    UserController maintains the restpoint to operate the various
    operations on the user entity, such as adding, deleting, updating and retrieving users.
    It interacts with the UserService to perform these operations.
    */

    private final UserService userService;
    

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //Using the GET method to retrieve user information by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id); //Request the id to the service layer
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers(); //Ask the service layer for all users
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
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        boolean updated = userService.updateUser(id, user);
        return updated ? "User updated successfully" : "User not found";
    }

}

