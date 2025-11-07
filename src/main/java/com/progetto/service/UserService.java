package com.progetto.service;

import com.progetto.exception.NoSuchUserExistsException;
import com.progetto.model.User;
import com.progetto.repository.JpaUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final JpaUserRepository jpaUserRepository;

    public UserService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public User getUser(String email) {
        Optional<User> user = jpaUserRepository.findByEmail(email);
        return user.orElseThrow(() -> new NoSuchUserExistsException(String.format("User with email %s not found", email)));
    }

    public User getUserById(long id) {
        Optional<User> user = jpaUserRepository.findById(id);
        return user.orElseThrow(() -> new NoSuchUserExistsException(String.format("User with id %d not found", id)));
    }

    public void addUser(User user) {
        jpaUserRepository.save(user);
    }

    public User addUser(String name, String email, String hashedPassword) {
        return jpaUserRepository.save(new User(name, email, hashedPassword));
    }

    public User updateUser(User user) {
        return jpaUserRepository.save(user);
    }

    public boolean removeUser(long id) {
        Optional<User> user = jpaUserRepository.findById(id);
        if (user.isPresent()) {
            jpaUserRepository.delete(user.get());
            return true;
        } else {
            return false;
        }
    }

    public List<User> getAllUsers() {
        return jpaUserRepository.findAll();
    }
}
