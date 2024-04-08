package org.nailproject.services.clientService;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientService {
    private final ClientRepository clientRepository;

    public UpdateClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Boolean updateClient(Client client) {
        //TODO validate

        //if ok
        return clientRepository.updateClient(client);
    }
}
