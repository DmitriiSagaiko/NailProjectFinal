package org.nailproject.services.designService;

import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllDesignsService {
    private final NailDesignRepository nailDesignRepository;

    public GetAllDesignsService(NailDesignRepository nailDesignRepository) {
        this.nailDesignRepository = nailDesignRepository;
    }

    public List<NailDesign> getAllDesigns(Client client) {
        //TODO client VALIDATION
        return nailDesignRepository.getAllDesigns(client);
    }
}
