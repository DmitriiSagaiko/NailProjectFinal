package org.nailproject.services.clientServiceJPA;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetAllClientsServiceJPA {

    private final ClientRepositoryJPA clientRepositoryJPA;

    public GetAllClientsServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public List<Client> getAllClients() {
        return clientRepositoryJPA.findAll();
    }

}
