package org.nailproject.services.clientServiceJPA;


import exceptions.AlreadyExistException;
import org.nailproject.dto.clients.ClientsRequestDTO;
import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.dto.clients.ConvertFromClientToResponseDTO;
import org.nailproject.dto.clients.ConvertFromClientsRequestDtoToClient;
import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddClientServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;
    private final ConvertFromClientsRequestDtoToClient convertFromClientsRequestDtoToClient = new ConvertFromClientsRequestDtoToClient();
    private final ConvertFromClientToResponseDTO convertFromClientToResponseDTO  = new ConvertFromClientToResponseDTO();

    public AddClientServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public ClientsResponseDTO addClient(ClientsRequestDTO request) {
        //check for this email in DB
        Optional<Client> clientOptional = clientRepositoryJPA.getClientByEmail(request.getEmail());

        if(clientOptional.isPresent()) {
            throw new AlreadyExistException("Client with email " + request.getEmail() + " already exist");
        }

        //convert request to client
        Client clientBeforeSave = convertFromClientsRequestDtoToClient.converToClient(request);
        //save client in DB
        Client clientAfterSave  = clientRepositoryJPA.save(clientBeforeSave);

        return convertFromClientToResponseDTO.convertToResponse(clientAfterSave);

    }


}
