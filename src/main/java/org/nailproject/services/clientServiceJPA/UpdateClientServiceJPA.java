package org.nailproject.services.clientServiceJPA;

import exceptions.NotFoundException;
import org.nailproject.dto.clients.*;
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

    public ClientsResponseDTO updateClient(ClientRequestForUpdateOrCreateDTO request) {
        Optional<Client> optionalClient = clientRepositoryJPA.findById(request.getId().toString());
        if(optionalClient.isEmpty()){
            throw new NotFoundException("Client with id " + request.getId()+ " not found");
        }

        Client client = optionalClient.get();

        client.setAge(request.getAge());
        client.setEmail(request.getEmail());
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());

        clientRepositoryJPA.save(client);

        return convertFromClientToResponseDTO.convertToResponse(client);


    }
}
