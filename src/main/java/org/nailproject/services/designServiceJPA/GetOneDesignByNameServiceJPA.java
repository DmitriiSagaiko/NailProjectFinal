package org.nailproject.services.designServiceJPA;

import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOneDesignByNameServiceJPA {
    private final NailDesignRepositoryJPA nailDesignRepositoryJPA;

    public GetOneDesignByNameServiceJPA(NailDesignRepositoryJPA nailDesignRepositoryJPA) {
        this.nailDesignRepositoryJPA = nailDesignRepositoryJPA;
    }

    public Optional<NailDesign> getOneDesignByName(String name) {
        //TODO validation
        return nailDesignRepositoryJPA.getNailDesignByName(name);
    }
}
