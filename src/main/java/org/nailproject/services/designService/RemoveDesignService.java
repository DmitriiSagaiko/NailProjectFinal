package org.nailproject.services.designService;

import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepository;
import org.nailproject.requestDTO.NailDesignClientRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class RemoveDesignService {
    private final NailDesignRepository nailDesignRepository;

    public RemoveDesignService(NailDesignRepository nailDesignRepository) {
        this.nailDesignRepository = nailDesignRepository;
    }

    public Boolean removeDesign(NailDesignClientRequestDTO request) {

        Client client = request.getClient();
        NailDesign design = request.getDesign();

        return nailDesignRepository.removeDesign(client, design.getName());
    }
}
