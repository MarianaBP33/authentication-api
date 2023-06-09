package dev.chetopuffet.authenticationapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.chetopuffet.authenticationapi.exception.BadRequestException;
import dev.chetopuffet.authenticationapi.exception.NotFoundException;
import dev.chetopuffet.authenticationapi.model.dto.AuthResponseDto;
import dev.chetopuffet.authenticationapi.model.dto.LoginRequestDto;
import dev.chetopuffet.authenticationapi.model.dto.RegisterRequestDto;
import dev.chetopuffet.authenticationapi.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping
  public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto registerRequestDto) {
    return ResponseEntity.ok(authService.login(registerRequestDto));
  }
  
  @PostMapping("/register")
  public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) throws BadRequestException {
    return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDto));
  }

  @PostMapping("/token/refresh/{token}")
  public ResponseEntity<AuthResponseDto> refreshToken(@PathVariable String token) throws NotFoundException, BadRequestException {
    return ResponseEntity.status(HttpStatus.OK).body(authService.refreshToken(token));
  }

  @GetMapping("/token/verify/{token}")
  public ResponseEntity<Boolean> verifyToken(@PathVariable String token) throws NotFoundException, BadRequestException {
    return ResponseEntity.status(HttpStatus.OK).body(authService.verifyToken(token));
  }
}
