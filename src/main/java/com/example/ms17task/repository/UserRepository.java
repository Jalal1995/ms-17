package com.example.ms17task.repository;

import com.example.ms17task.model.security.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  @EntityGraph(value = "User.authorities")
  Optional<User> findByUsername(String username);

}
