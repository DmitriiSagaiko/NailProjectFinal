package org.nailproject.services.clientService;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetClientByEmailService {
    private final ClientRepository clientRepository;

    public GetClientByEmailService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> getClientByEmail(String email) {
        //TODO email Validation for sure
        //if ok

        return clientRepository.getClientByEmail(email);
    }
}
