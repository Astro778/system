package com.progetto.service;

import com.progetto.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    // Recupera tutti gli utenti
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Recupera un utente per ID
    public User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Aggiunge un nuovo utente
    public void addUser(User user) {
        users.add(user);
    }

    // Aggiorna un utente esistente
    public boolean updateUser(int id, User newUser) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == id) {
                users.set(i, newUser);
                return true;
            }
        }
        return false;
    }

    // Elimina un utente
    public boolean removeUser(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}
