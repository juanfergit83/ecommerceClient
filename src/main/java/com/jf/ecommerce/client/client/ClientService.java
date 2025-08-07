package com.jf.ecommerce.client.client;

import com.jf.ecommerce.client.exception.ObjectAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class ClientService {

  private ClientRepository clientRepository;

  private MessageSource messageSource;

  @Autowired
  private ClientMapper clientMapper;

  public ClientService(ClientRepository clientRepository, MessageSource messageSource) {
    this.clientRepository = clientRepository;
    this.messageSource = messageSource;
  }

  public void clientRegister(ClientDTO clientDTO) {
    Optional<Client> optionalClient = clientRepository.findByDocumentTypeAndDocumentId(clientDTO.getDocumentType(), clientDTO.getDocumentId());
    if (optionalClient.isPresent()) {
      throw new ObjectAlreadyExistsException(messageSource.getMessage("client.already.exists", null, Locale.forLanguageTag("en")));
    }
    var client = clientMapper.toEntity(clientDTO);
    clientRepository.save(client);
  }

}
