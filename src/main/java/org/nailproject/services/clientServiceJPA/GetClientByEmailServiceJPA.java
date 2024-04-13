package org.nailproject.services.clientServiceJPA;

import exceptions.NotFoundException;
import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.dto.clients.ConvertFromClientToResponseDTO;
import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetClientByEmailServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;
    private final ConvertFromClientToResponseDTO convertFromClientToResponseDTO = new ConvertFromClientToResponseDTO();


    public GetClientByEmailServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public ClientsResponseDTO getClientByEmail(String email) {

        Optional<Client> optionalClient = clientRepositoryJPA.getClientByEmail(email);
        if (optionalClient.isEmpty()) {
            throw new NotFoundException("Client with email " + email + " not found");
        }

        return convertFromClientToResponseDTO.convertToResponse(optionalClient.get());
    }
}
