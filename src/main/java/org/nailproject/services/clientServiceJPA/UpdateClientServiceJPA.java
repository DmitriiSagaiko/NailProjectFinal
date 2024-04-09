package org.nailproject.services.clientServiceJPA;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;

    public UpdateClientServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public Boolean updateClient(Client client) {
        Client addClient = clientRepositoryJPA.save(client);

        return addClient.equals(clientRepositoryJPA.getClientByEmail(client.getEmail()).get());


    }
}