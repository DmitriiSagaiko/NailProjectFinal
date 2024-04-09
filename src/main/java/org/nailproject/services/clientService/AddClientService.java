package org.nailproject.services.clientService;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepository;
import org.nailproject.repository.ClientRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddClientService {
    private final ClientRepository clientRepository;


    public AddClientService(ClientRepository clientRepository, ClientRepositoryJPA clientRepositoryJPA) {
        this.clientRepository = clientRepository;
    }

    public Boolean addClient(Client client) {
        //TODO client validation
        //name length, surname length, not null, email validator
        //if valid
        Optional<Client> clientOptional = clientRepository.addClient(client);
        return clientOptional.isPresent();
//        return true;
    }

}
