package org.nailproject.services.clientServiceJPA;

import exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.dto.clients.ConvertFromClientToResponseDTO;
import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindClientByIdServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;
    private final ConvertFromClientToResponseDTO converter;


    public Optional<Client> findOptionalClientById(Integer id) {
        Optional<Client> optionalClient = clientRepositoryJPA.findById(id.toString());
        if (optionalClient.isEmpty()) {
            throw new NotFoundException("Client with id " + id + " not found");
        }

        return optionalClient;
    }
}
