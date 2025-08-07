package com.jf.ecommerce.client.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

  Optional<Client> findByDocumentTypeAndDocumentId(String documentType, String documentId);

}
