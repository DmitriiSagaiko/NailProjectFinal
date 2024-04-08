package org.nailproject.services.clientService;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllClientsService {
    private final ClientRepository clientRepository;

    public GetAllClientsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

}
