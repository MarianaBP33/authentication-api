package dev.chetopuffet.authenticationapi.repository;

import java.util.List;
import dev.chetopuffet.authenticationapi.model.Paro;

public interface ParoRepository {

    List<Paro> findAllByActiveTrue();
    
}
