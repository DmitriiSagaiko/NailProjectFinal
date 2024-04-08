package org.nailproject.services.designService;

import org.nailproject.annotation.CarlosPayAttention;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepository;
import org.springframework.stereotype.Service;

@Service
public class ShareDesignService {
    private final NailDesignRepository nailDesignRepository;

    public ShareDesignService(NailDesignRepository nailDesignRepository) {
        this.nailDesignRepository = nailDesignRepository;
    }


    //TODO for V2
    @CarlosPayAttention(whatToDo = "just think about it and make your idea for future")
    public void shareDesign(NailDesign design) {
        nailDesignRepository.shareDesign(design);
    }
}
