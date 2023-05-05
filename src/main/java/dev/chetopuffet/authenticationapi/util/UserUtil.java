package dev.chetopuffet.authenticationapi.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

import dev.chetopuffet.authenticationapi.exception.NotFoundException;
import dev.chetopuffet.authenticationapi.model.User;
import dev.chetopuffet.authenticationapi.model.dto.UserDto;
import dev.chetopuffet.authenticationapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserUtil {

  private final UserRepository userRepository;

  public User getUserByEmail(String email) throws NotFoundException {
    return userRepository.findByEmailAndActiveTrue(email).orElseThrow(
      () -> new NotFoundException("User not found")
    );
  }

  public User getUserById(String id) throws NotFoundException {
    return userRepository.findByIdAndActiveTrue(UUID.fromString(id)).orElseThrow(
      () -> new NotFoundException("User not found")
    );
  }

  public UserDto transformUserToUserDto(User user) {
    var userDto = UserDto.builder()
      .id(user.getId().toString())
      .firstName(user.getFirstName())
      .lastName(user.getLastName())
      .email(user.getEmail())
      .role(user.getRole().name())
      .phone(user.getPhone())
      .build();
    return userDto;
  }
}
