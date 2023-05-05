package dev.chetopuffet.authenticationapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
  private String firstName;  
  private String lastName;  
  private String email;  
  private String password;  
  private String phone;  
  private String adminId;
}
