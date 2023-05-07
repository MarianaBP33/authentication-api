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
import dev.chetopuffet.authenticationapi.model.dto.ParoDto;
import dev.chetopuffet.authenticationapi.model.Paro;
import dev.chetopuffet.authenticationapi.service.ParoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/paro")
@RequiredArgsConstructor
public class ParoController {
    
    private final ParoService paroService;

    @GetMapping()
    public ResponseEntity<List<ParoDto>> getAllParos() throws NotFoundException, BadRequestException {
      return ResponseEntity.status(HttpStatus.OK).body(paroService.getAllParos());
    }

    @PostMapping()
    public ResponseEntity <Paro> createParo(@RequestBody String ownerName, String description, Integer points) {
      return ResponseEntity.status(HttpStatus.OK).body(paroService.createParo(ownerName, description, points));
    }
}
