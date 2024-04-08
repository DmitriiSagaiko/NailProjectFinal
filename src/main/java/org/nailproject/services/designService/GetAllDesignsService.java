package org.nailproject.services.designService;

import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.ClientRepository;
import org.nailproject.repository.NailDesignRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GetAllDesignsService {
    private final NailDesignRepository nailDesignRepository;
    private final ClientRepository clientRepository;

    public GetAllDesignsService(NailDesignRepository nailDesignRepository, ClientRepository clientRepository) {
        this.nailDesignRepository = nailDesignRepository;
        this.clientRepository = clientRepository;
    }

    public List<NailDesign> getAllDesigns(String email) {
        //TODO email VALIDATION
        Optional<Client> clientOptional = clientRepository.getClientByEmail(email);
        if(clientOptional.isPresent()) {
        return nailDesignRepository.getAllDesigns(clientOptional.get());
        }
        return Collections.emptyList();
    }
}
