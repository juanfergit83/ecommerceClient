package com.jf.ecommerce.client.client;

import com.jf.ecommerce.client.config.SecurityConfig;
import com.jf.ecommerce.client.exception.ObjectAlreadyExistsException;
import org.flywaydb.core.internal.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ClientService clientService;

  private ClientDTO clientDTO = ClientDTO.builder()
    .documentType("CC")
    .documentId("12345")
    .firstName("Antony")
    .lastName("Lee")
    .build();

  @Test
  void registerClient_Success() throws Exception {
    doNothing().when(clientService).clientRegister(any());
    this.mockMvc.perform(post("/client/register")
      .with(httpBasic("juanfer", "pass1234"))
      .contentType(MediaType.APPLICATION_JSON)
      .content(JsonUtils.toJson(clientDTO)))
      .andExpect(status().isOk());
  }

  @Test
  void registerClient_ClientAlreadyExist() throws Exception {
    doThrow(new ObjectAlreadyExistsException("Client is already registered")).when(clientService).clientRegister(any());
    this.mockMvc.perform(post("/client/register")
        .with(httpBasic("juanfer", "pass1234"))
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonUtils.toJson(clientDTO)))
      .andExpect(status().isConflict())
      .andExpect(content().string("Client is already registered"));
  }

  @Test
  void registerClient_WrongCredentials() throws Exception {
    doThrow(new ObjectAlreadyExistsException("Client is already registered")).when(clientService).clientRegister(any());
    this.mockMvc.perform(post("/client/register")
        .with(httpBasic("juanfer", "XXXX"))
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonUtils.toJson(clientDTO)))
      .andExpect(status().isUnauthorized());
  }
  
}
