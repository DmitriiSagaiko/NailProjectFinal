package org.nailproject.services.designService;

import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepository;
import org.springframework.stereotype.Service;

@Service
public class AddDesignService {
    private final NailDesignRepository nailDesignRepository;

    public AddDesignService(NailDesignRepository nailDesignRepository) {
        this.nailDesignRepository = nailDesignRepository;
    }

    public Boolean addNailDesign(NailDesign design, Client client) {
        //TODo Validation of Design
        //if ok

        return nailDesignRepository.addDesign(design, client);
    }
}
