package com.jf.ecommerce.client.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping("/register")
  public ResponseEntity<String> clientRegister(@RequestBody ClientDTO clientDTO) {
    clientService.clientRegister(clientDTO);
    return ResponseEntity.ok("");
  }

}
