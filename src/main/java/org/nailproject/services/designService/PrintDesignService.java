package org.nailproject.services.designService;

import org.nailproject.annotation.CarlosPayAttention;
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
    @CarlosPayAttention(whatToDo = "Just think about it and make an idea")
    public void printDesign(NailDesign design) {
        nailDesignRepository.printDesign(design);
    }
}
