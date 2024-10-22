package com.example.usermanagement.user.service;

import com.example.usermanagement.user.model.User;
import com.example.usermanagement.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "user-events";

    public User registerUser(User user) {
        User savedUser = userRepository.save(user);
        kafkaTemplate.send(TOPIC, "User registered: " + savedUser.getUsername());
        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        kafkaTemplate.send(TOPIC, "User deleted with id: " + id);
    }
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            existingUser.get().setUsername(user.getUsername());
            existingUser.get().setPassword(user.getPassword());
            existingUser.get().setRole(user.getRole());
            User updatedUser = userRepository.save(existingUser.get());
            kafkaTemplate.send(TOPIC, "User updated: " + updatedUser.getUsername());
            return updatedUser;
        }
        return null;
    }
}
