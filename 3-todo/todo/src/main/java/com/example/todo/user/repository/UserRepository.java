package com.example.todo.user.repository;

import com.example.todo.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    Long saveAndReturnKey(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    void updateName(Long id, String name);
}
