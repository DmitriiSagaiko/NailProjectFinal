package org.nailproject.services.designService;

import org.nailproject.entity.client.Client;
import org.nailproject.repository.NailDesignRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveDesignService {
    private final NailDesignRepository nailDesignRepository;

    public RemoveDesignService(NailDesignRepository nailDesignRepository) {
        this.nailDesignRepository = nailDesignRepository;
    }

    public Boolean removeDesign(String name, Client client) {

        return nailDesignRepository.removeDesign(client,name);
    }
}
