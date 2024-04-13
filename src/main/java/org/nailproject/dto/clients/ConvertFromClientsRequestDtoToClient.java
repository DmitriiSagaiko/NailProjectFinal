package org.nailproject.dto.clients;

import org.nailproject.entity.client.Client;

public class ConvertFromClientsRequestDtoToClient {

    public Client converToClient(ClientsRequestDTO request){
        Client result = new Client();
        if(request.getEmail() != null){
            result.setEmail(request.getEmail());
        }
        if(request.getAge() != 0){
            result.setAge(request.getAge());
        }
        if(request.getFirstName() != null){
            result.setFirstName(request.getFirstName());
        }
        if(request.getLastName() != null){
            result.setLastName(request.getLastName());
        }

        return result;
    }
}
