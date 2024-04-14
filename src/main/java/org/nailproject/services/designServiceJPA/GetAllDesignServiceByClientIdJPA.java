package org.nailproject.services.designServiceJPA;

import exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class GetAllDesignServiceByClientIdJPA {
    private final NailDesignRepositoryJPA nailDesignRepositoryJPA;


    public List<NailDesign> getAllDesignsById(Integer clientId) {

        if (clientId == null || clientId < 1) {
            throw new NotFoundException("Client id is null or less than 1");
        }

        return nailDesignRepositoryJPA.getNailDesignByClient_Id(clientId);
    }
}
