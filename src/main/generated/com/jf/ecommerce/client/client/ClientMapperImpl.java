package com.jf.ecommerce.client.client;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-04T21:17:11-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO toDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO.ClientDTOBuilder clientDTO = ClientDTO.builder();

        clientDTO.documentId( client.getDocumentId() );
        clientDTO.documentType( client.getDocumentType() );
        clientDTO.firstName( client.getFirstName() );
        clientDTO.lastName( client.getLastName() );

        return clientDTO.build();
    }

    @Override
    public Client toEntity(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.documentId( clientDTO.getDocumentId() );
        client.documentType( clientDTO.getDocumentType() );
        client.firstName( clientDTO.getFirstName() );
        client.lastName( clientDTO.getLastName() );

        return client.build();
    }
}
