package org.nailproject.dto.clients;

import org.nailproject.entity.client.Client;
import org.springframework.stereotype.Component;

@Component

public class ConvertFromClientToResponseDTO {

    public ClientsResponseDTO convertToResponse(Client client) {
        ClientsResponseDTO responseDTO = new ClientsResponseDTO();
        responseDTO.setAge(client.getAge());
        responseDTO.setId(client.getId());
        responseDTO.setEmail(client.getEmail());
        responseDTO.setFirstName(client.getFirstName());
        responseDTO.setLastName(client.getLastName());
        responseDTO.setPhoneNumber(client.getPhoneNumber());
        return responseDTO;
    }
}
