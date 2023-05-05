package dev.chetopuffet.authenticationapi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.chetopuffet.authenticationapi.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByEmailAndActiveTrue(String username);
  
}
