package dev.chetopuffet.authenticationapi.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractSimpleEntity {
  @Id
  @GeneratedValue(generator="uuid")
  @GenericGenerator(
    name="uuid",
    strategy="org.hibernate.id.UUIDGenerator"
  )
  @Column(
    name="id",
    updatable=false,
    nullable=false,
    unique=true
  )
  private UUID id;
}
