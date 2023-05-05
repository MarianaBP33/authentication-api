package dev.chetopuffet.authenticationapi.model;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractModificationAttributesEntity extends AbstractSimpleEntity {

  @Column(name="created_by")
  private UUID createdBy;

  @Column(name="updated_by")
  private UUID updatedBy;

  @Column(name="created_date")
  @CreationTimestamp
  private LocalDate createdDate;

  @Column(name="updated_date")
  @UpdateTimestamp
  private LocalDate updatedDate;

  @Column(name="active")
  private boolean active;

}