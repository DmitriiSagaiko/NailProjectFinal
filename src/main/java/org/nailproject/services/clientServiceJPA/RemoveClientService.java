package org.nailproject.services.clientServiceJPA;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoveClientService {
    private final ClientRepositoryJPA clientRepositoryJPA;

    public RemoveClientService(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public Boolean removeClientByEmail(String email){
        Optional<Client> optionalClient = clientRepositoryJPA.removeClientByEmail(email);
        return optionalClient.isPresent();
    }
}
