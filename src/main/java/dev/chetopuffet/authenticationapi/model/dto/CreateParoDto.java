package dev.chetopuffet.authenticationapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateParoDto {
  private String description;
  private Integer points;
  private String ownerName;
}
