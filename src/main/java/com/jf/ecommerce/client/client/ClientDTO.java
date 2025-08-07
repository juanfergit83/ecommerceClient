package com.jf.ecommerce.client.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

  private String documentType;

  private String documentId;

  private String firstName;

  private String lastName;

}
