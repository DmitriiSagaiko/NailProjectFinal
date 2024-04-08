package org.nailproject.services.designService;

import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.ClientRepository;
import org.nailproject.repository.NailDesignRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOneDesignByNameService {
    private final NailDesignRepository nailDesignRepository;
    private final ClientRepository clientRepository;

    public GetOneDesignByNameService(NailDesignRepository nailDesignRepository, ClientRepository clientRepository) {
        this.nailDesignRepository = nailDesignRepository;
        this.clientRepository = clientRepository;
    }

    public Optional<NailDesign> getOneDesignByName(String data) {
        //TODO Validation for  name
        //TODO Validation for a email
        String[] nameEmail= data.split(",");
        String name = nameEmail[0];
        String email = nameEmail[1];
        Optional<Client> optionalClient = clientRepository.getClientByEmail(email);
        if (optionalClient.isPresent()) {
            return nailDesignRepository.getOneDesign(name, optionalClient.get());
        }
        return Optional.empty();
    }
}
