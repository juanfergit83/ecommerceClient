package com.jf.ecommerce.client.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "client")
public class Client {

  @Id
  @UuidGenerator
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID uuid;

  @NotNull
  @Column(name = "document_type")
  private String documentType;

  @NotNull
  @Column(name = "document_id")
  private String documentId;

  @NotNull
  @Column(name = "first_Name")
  private String firstName;

  @NotNull
  @Column(name = "last_Name")
  private String lastName;

  @CreationTimestamp
  @Column(name = "creation_date")
  private LocalDateTime creationDate;

  @UpdateTimestamp
  @Column(name = "last_Update")
  private LocalDateTime lastUpdate;

}
