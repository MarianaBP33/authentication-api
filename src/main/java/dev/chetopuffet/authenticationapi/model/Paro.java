package dev.chetopuffet.authenticationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="paros")
public class Paro  extends AbstractModificationAttributesEntity{
    
    @Column(name="ownerName", nullable=false)
    private String ownerName;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="points", nullable=false)
    private Integer points;

    @Column(name="active")
    private Boolean active;
    
}
