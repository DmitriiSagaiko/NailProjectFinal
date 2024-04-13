package org.nailproject.services.clientServiceJPA;

import exceptions.NotFoundException;
import org.nailproject.dto.clients.ClientsRequestDTO;
import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.dto.clients.ConvertFromClientToResponseDTO;
import org.nailproject.dto.clients.ConvertFromClientsRequestDtoToClient;
import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateClientServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;
    private final ConvertFromClientToResponseDTO convertFromClientToResponseDTO = new ConvertFromClientToResponseDTO();
    private final ConvertFromClientsRequestDtoToClient convertFromClientsRequestDtoToClient = new ConvertFromClientsRequestDtoToClient();

    public UpdateClientServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public ClientsResponseDTO updateClient(ClientsRequestDTO request) {
        Optional<Client> optionalClient = clientRepositoryJPA.getClientByEmail(request.getEmail());
        if(optionalClient.isEmpty()){
            throw new NotFoundException("Client not found");
        }
        Client beforeUpdate = convertFromClientsRequestDtoToClient.converToClient(request);
        Client afterUpdate = clientRepositoryJPA.save(beforeUpdate);

        return convertFromClientToResponseDTO.convertToResponse(afterUpdate);


    }
}
