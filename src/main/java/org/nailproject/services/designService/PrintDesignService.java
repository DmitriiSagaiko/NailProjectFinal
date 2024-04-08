package org.nailproject.services.designService;

import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepository;
import org.springframework.stereotype.Service;

@Service
public class PrintDesignService {
    private final NailDesignRepository nailDesignRepository;

    public PrintDesignService(NailDesignRepository nailDesignRepository) {
        this.nailDesignRepository = nailDesignRepository;
    }


    //TODO for Version 2
    public void printDesign(NailDesign design) {
        nailDesignRepository.printDesign(design);
    }
}
