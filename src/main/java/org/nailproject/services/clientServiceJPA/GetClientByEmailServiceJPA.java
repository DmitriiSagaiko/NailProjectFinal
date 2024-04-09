package org.nailproject.services.clientServiceJPA;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetClientByEmailServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;


    public GetClientByEmailServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public Optional<Client> getClientByEmail(String email) {
        return clientRepositoryJPA.getClientByEmail(email);
    }
}
