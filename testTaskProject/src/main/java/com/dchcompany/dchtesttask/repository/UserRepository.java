package com.dchcompany.dchtesttask.repository;

import com.dchcompany.dchtesttask.entity.Student;
import com.dchcompany.dchtesttask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    Optional<User> findFirstById(Long id);
    Optional<User> findFirstByUsername(String username);
}
