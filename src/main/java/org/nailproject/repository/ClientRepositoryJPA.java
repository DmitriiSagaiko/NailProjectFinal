package org.nailproject.repository;

import org.nailproject.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepositoryJPA extends JpaRepository<Client, String> {
    Optional<Client> getClientByEmail(String email);
    Optional<Client> removeClientByEmail(String email);


}
