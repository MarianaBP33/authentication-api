package dev.chetopuffet.authenticationapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@Entity
@Table(name="establecimientos")
public class Establecimientos extends AbstractNamedEntity {

}
