package org.nailproject.services.clientServiceJPA;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;

import java.util.Optional;

public class GetClientByEmailService {
    private final ClientRepositoryJPA clientRepositoryJPA;


    public GetClientByEmailService(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public Optional<Client> getClientByEmail(String email) {
        return clientRepositoryJPA.getClientByEmail(email);
    }
}
