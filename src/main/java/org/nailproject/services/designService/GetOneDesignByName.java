package org.nailproject.services.designService;

import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepository;
import org.springframework.stereotype.Service;

import java.awt.image.TileObserver;
import java.util.Optional;

@Service
public class GetOneDesignByName {
    private final NailDesignRepository nailDesignRepository;

    public GetOneDesignByName(NailDesignRepository nailDesignRepository) {
        this.nailDesignRepository = nailDesignRepository;
    }

    public Optional<NailDesign> getOneDesignByName (String name, Client client) {
        //TODO Validation for  name
        //TODO Validation for a client
       return nailDesignRepository.getOneDesign(name,client);
    }
}
