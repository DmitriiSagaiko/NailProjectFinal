package org.nailproject.services.clientServiceJPA;

import lombok.RequiredArgsConstructor;
import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindClientByIdServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;

    public Optional<Client> findClientById(Integer id) {
        return clientRepositoryJPA.findById(id.toString());
    }
}
