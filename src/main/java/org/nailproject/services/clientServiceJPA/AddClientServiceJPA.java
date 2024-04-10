package org.nailproject.services.clientServiceJPA;


import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class AddClientServiceJPA {
    private final ClientRepositoryJPA clientRepositoryJPA;

    public AddClientServiceJPA(ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepositoryJPA = clientRepositoryJPA;
    }

    public Boolean addClient(Client client) {
        //TODO check client
        clientRepositoryJPA.save(client);

        return true;
    }


}
