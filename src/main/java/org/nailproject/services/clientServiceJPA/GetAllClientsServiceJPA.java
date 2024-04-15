package org.nailproject.services.clientServiceJPA;

import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.dto.clients.ConvertFromClientToResponseDTO;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetAllClientsServiceJPA {

    private final ClientRepositoryJPA clientRepositoryJPA;
    private final ConvertFromClientToResponseDTO convertFromClientToResponseDTO = new ConvertFromClientToResponseDTO();

    public GetAllClientsServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public List<ClientsResponseDTO> getAllClients() {

        return clientRepositoryJPA.findAll().stream().map(convertFromClientToResponseDTO::convertToResponse).toList();
    }

}
