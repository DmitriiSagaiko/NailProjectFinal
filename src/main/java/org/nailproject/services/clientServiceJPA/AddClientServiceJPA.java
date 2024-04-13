package org.nailproject.services.clientServiceJPA;


import exceptions.AlreadyExistException;
import org.nailproject.dto.clients.*;
import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddClientServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;
    private final ConvertFromCreateOrUpdateClientRequestToClient convert = new ConvertFromCreateOrUpdateClientRequestToClient();
    private final ConvertFromClientToResponseDTO convertFromClientToResponseDTO = new ConvertFromClientToResponseDTO();

    public AddClientServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public ClientsResponseDTO addClient(ClientRequestForUpdateOrCreateDTO request) {
        //check for this email in DB
        Optional<Client> clientOptional = clientRepositoryJPA.getClientByEmail(request.getEmail());

        if (clientOptional.isPresent()) {
            throw new AlreadyExistException("Client with email " + request.getEmail() + " already exist");
        }

        //convert request to client
        Client clientBeforeSave = convert.converToClient(request);
        //save client in DB
        Client clientAfterSave = clientRepositoryJPA.save(clientBeforeSave);

        return convertFromClientToResponseDTO.convertToResponse(clientAfterSave);

    }


}
