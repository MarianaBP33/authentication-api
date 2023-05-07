package dev.chetopuffet.authenticationapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParoDto {
    private String description;
    private String ownerName;
    private Integer points;
    private Boolean active;
    
}
