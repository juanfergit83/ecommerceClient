package com.jf.ecommerce.client.client;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  @Mapping(source = "documentId", target = "documentId")
  ClientDTO toDTO(Client client);

  @Mapping(source = "documentId", target = "documentId")
  Client toEntity(ClientDTO clientDTO);

}
