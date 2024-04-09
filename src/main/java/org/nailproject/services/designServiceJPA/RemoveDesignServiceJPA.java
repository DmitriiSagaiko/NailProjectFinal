package org.nailproject.services.designServiceJPA;

import org.nailproject.repository.NailDesignRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class RemoveDesignServiceJPA {
    private final NailDesignRepositoryJPA nailDesignRepositoryJPA;

    public RemoveDesignServiceJPA(NailDesignRepositoryJPA nailDesignRepositoryJPA) {
        this.nailDesignRepositoryJPA = nailDesignRepositoryJPA;
    }

    public Boolean removeDesignById(Integer id) {
        nailDesignRepositoryJPA.deleteById(id);
        return nailDesignRepositoryJPA.findById(id).isEmpty();
    }
}
