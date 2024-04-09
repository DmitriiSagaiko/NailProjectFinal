package org.nailproject.services.designServiceJPA;

import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetAllDesignServiceByClientIdJPA {
    private final NailDesignRepositoryJPA nailDesignRepositoryJPA;


    public GetAllDesignServiceByClientIdJPA(NailDesignRepositoryJPA nailDesignRepositoryJPA) {
        this.nailDesignRepositoryJPA = nailDesignRepositoryJPA;
    }

    public List<NailDesign> getAllDesignsById(Integer clientId) {
        return nailDesignRepositoryJPA.getNailDesignByClient_Id(clientId);
    }
}
