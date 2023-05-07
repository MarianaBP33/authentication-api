package dev.chetopuffet.authenticationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="productos")
public class Productos extends AbstractModificationAttributesEntity{

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="points")
    private Integer points;

    @Column(name="code")
    private String code;

    @JoinColumn(name="establecimiento_id", nullable=false)
    @ManyToOne
    private Establecimientos establecimiento_id;
}
