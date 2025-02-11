package com.example.todo.user.repository;

import com.example.todo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    @Modifying
    @Query(
            value = "UPDATE users SET deleted_at = NOW() where id = ?",
            nativeQuery = true
    )
    void softDelete(Long userId);
}
