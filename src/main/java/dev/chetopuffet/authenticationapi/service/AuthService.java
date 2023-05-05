package dev.chetopuffet.authenticationapi.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.chetopuffet.authenticationapi.configuration.PropertiesConfig;
import dev.chetopuffet.authenticationapi.exception.BadRequestException;
import dev.chetopuffet.authenticationapi.exception.NotFoundException;
import dev.chetopuffet.authenticationapi.model.User;
import dev.chetopuffet.authenticationapi.model.dto.AuthResponseDto;
import dev.chetopuffet.authenticationapi.model.dto.LoginRequestDto;
import dev.chetopuffet.authenticationapi.model.dto.RegisterRequestDto;
import dev.chetopuffet.authenticationapi.model.enums.Role;
import dev.chetopuffet.authenticationapi.repository.UserRepository;
import dev.chetopuffet.authenticationapi.util.JwtUtil;
import dev.chetopuffet.authenticationapi.util.UserUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final PropertiesConfig propertiesConfig;
  private final JwtUtil jwtUtil;
  private final UserUtil userUtil;
  private final UserRepository userRepository;

  public AuthResponseDto login(LoginRequestDto request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = userRepository.findByEmailAndActiveTrue(request.getEmail()).orElseThrow();
    var jwt = jwtUtil.generateToken(user, propertiesConfig.getJwtAccessExpirationMs());
    return AuthResponseDto.builder()
      .token(jwt)
      .user(userUtil.transformUserToUserDto(user))
      .build();
  }

  public AuthResponseDto register(RegisterRequestDto request) throws BadRequestException {
    if (request.getPassword().length() < 6) {
      throw new BadRequestException("Password must be at least 6 characters long");
    }
    if (userRepository.existsByEmailAndActiveTrue(request.getEmail())) {
      throw new BadRequestException("Email already exists");
    }
    var user = User.builder()
      .firstName(request.getFirstName())
      .lastName(request.getLastName())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .phone(request.getPhone())
      .role(Role.ROLE_USER)
      .build();
    user.setActive(true);
    var savedUser = userRepository.save(user);
    var jwt = jwtUtil.generateToken(user, propertiesConfig.getJwtAccessExpirationMs());
    return AuthResponseDto.builder()
      .token(jwt)
      .user(userUtil.transformUserToUserDto(savedUser))
      .build();
  }

  public AuthResponseDto refreshToken(String token) throws NotFoundException, BadRequestException {
    var email = jwtUtil.extractUsername(token);
    var user = userUtil.getUserByEmail(email);
    if (!jwtUtil.isTokenValid(token, user)) {
      token = jwtUtil.generateToken(user, propertiesConfig.getJwtAccessExpirationMs());
    }
    return AuthResponseDto.builder()
      .token(token)
      .user(userUtil.transformUserToUserDto(user))
      .build();
  }

  public Boolean verifyToken(String token) throws NotFoundException, BadRequestException {
    var email = jwtUtil.extractUsername(token);
    var user = userUtil.getUserByEmail(email);
    return jwtUtil.isTokenValid(token, user);
  }
}
