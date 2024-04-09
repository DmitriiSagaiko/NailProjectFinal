package org.nailproject.services.designServiceJPA;

import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.nailproject.requestDTO.NailDesignClientRequestDTO;
import org.springframework.stereotype.Service;


@Service
public class AddDesignServiceJPA {
    private final NailDesignRepositoryJPA nailDesignRepositoryJPA;

    public AddDesignServiceJPA(NailDesignRepositoryJPA nailDesignRepositoryJPA) {
        this.nailDesignRepositoryJPA = nailDesignRepositoryJPA;
    }

    public Boolean addNailDesign(NailDesignClientRequestDTO requestDTO) {
        NailDesign design = nailDesignRepositoryJPA.save(requestDTO.getDesign());
        return !design.getName().isEmpty();
    }
}
