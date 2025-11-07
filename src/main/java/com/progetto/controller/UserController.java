package com.progetto.controller;

import com.progetto.model.User;
import com.progetto.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    /*
    UserController maintains the restpoint to operate the various
    operations on the user entity, such as adding, deleting, updating and retrieving users.
    It interacts with the UserService to perform these operations.
    */

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    curl -X GET http://localhost:8080/api/users/1
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    /*
    curl -X GET http://localhost:8080/api/users
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /*
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{"name":"Alice","email":"alice@example.com","hashPassword":"abc123hashed"}'
     */
    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully" + user.getName();
    }

    /*
    curl -X DELETE http://localhost:8080/api/users/1
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        boolean removed = userService.removeUser(id);
        return removed ? "User deleted successfully" : "User not found";
    }

    /*
    curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"id":1,"name":"Alice Updated","email":"alice.upd@example.com","hashPassword":"newhashed"}'
     */
    @PutMapping("/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        boolean updated;
        try {
            userService.updateUser(user);
            updated = true;
        } catch (Exception e) {
            updated = false;
        }
        return updated ? "User updated successfully" : "User not found";
    }
}

