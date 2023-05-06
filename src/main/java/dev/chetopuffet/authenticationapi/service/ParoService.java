package dev.chetopuffet.authenticationapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.chetopuffet.authenticationapi.model.Paro;
import dev.chetopuffet.authenticationapi.repository.ParoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParoService {

    private final ParoRepository paroRepository;

    public List<Paro> getAllParos(){
        return paroRepository.findAllByActiveTrue();

    }
    
}
