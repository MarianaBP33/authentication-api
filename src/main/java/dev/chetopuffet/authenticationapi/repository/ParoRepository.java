package dev.chetopuffet.authenticationapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.chetopuffet.authenticationapi.model.Paro;

public interface ParoRepository extends JpaRepository<Paro, UUID> {
  List<Paro> findAllByActiveTrue();
}
