package org.nailproject.services.clientService;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoveClientService {
    private final ClientRepository clientRepository;

    public RemoveClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Boolean removeClientByEmail(String email){
        Optional<Client> removed = clientRepository.removeClient(email);
        return removed.isPresent();
    }
}
