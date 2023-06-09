package dev.chetopuffet.authenticationapi.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.chetopuffet.authenticationapi.exception.BadRequestException;
import dev.chetopuffet.authenticationapi.exception.NotFoundException;
import dev.chetopuffet.authenticationapi.model.dto.CreateParoDto;
import dev.chetopuffet.authenticationapi.model.dto.ParoDto;
import dev.chetopuffet.authenticationapi.model.Paro;
import dev.chetopuffet.authenticationapi.service.ParoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/paro")
@RequiredArgsConstructor
public class ParoController {
    
    private final ParoService paroService;

    @GetMapping
    public ResponseEntity<List<ParoDto>> getAllParos() throws NotFoundException, BadRequestException {
      return ResponseEntity.status(HttpStatus.OK).body(paroService.getAllParos());
    }

    @PostMapping
    public ResponseEntity<Paro> createParo(@RequestBody CreateParoDto createParoDto) {
      return ResponseEntity.status(HttpStatus.CREATED).body(paroService.createParo(createParoDto));
    }
}
