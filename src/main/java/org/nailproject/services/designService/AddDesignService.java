package org.nailproject.services.designService;

import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepository;
import org.nailproject.requestDTO.NailDesignClientRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class AddDesignService {
    private final NailDesignRepository nailDesignRepository;

    public AddDesignService(NailDesignRepository nailDesignRepository) {
        this.nailDesignRepository = nailDesignRepository;
    }

    public Boolean addNailDesign(NailDesignClientRequestDTO request) {

        Client client = request.getClient();
        NailDesign design = request.getDesign();
        //TODo Validation of Design and  client
        //if ok

        return nailDesignRepository.addDesign(design, client);
    }
}
