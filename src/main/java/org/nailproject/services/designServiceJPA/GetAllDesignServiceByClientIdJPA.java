package org.nailproject.services.designServiceJPA;

import exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.nailproject.dto.design.ConvertFromNailDesignToResponse;
import org.nailproject.dto.design.DesignResponseDTO;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class GetAllDesignServiceByClientIdJPA {
    private final NailDesignRepositoryJPA nailDesignRepositoryJPA;
    private final ConvertFromNailDesignToResponse converter;


    public List<DesignResponseDTO> getAllDesignsById(Integer clientId) {

        if (clientId == null || clientId < 1) {
            throw new NotFoundException("Client id is null or less than 1");
        }

        List<NailDesign> designs = nailDesignRepositoryJPA.getNailDesignByClient_Id(clientId);

        List<DesignResponseDTO> designResponseDTOs = new ArrayList<>();
        for (NailDesign design : designs) {
            designResponseDTOs.add(converter.convert(design));
        }
        return designResponseDTOs;

    }
}
