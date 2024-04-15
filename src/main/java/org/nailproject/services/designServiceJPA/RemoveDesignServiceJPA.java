package org.nailproject.services.designServiceJPA;

import exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.nailproject.dto.design.ConvertFromNailDesignToResponse;
import org.nailproject.dto.design.DesignResponseDTO;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoveDesignServiceJPA {
    private final NailDesignRepositoryJPA nailDesignRepositoryJPA;
    private final ConvertFromNailDesignToResponse converter;


    public DesignResponseDTO removeDesignById(Integer id) {
        if (id == null || id <= 0) {
            throw new InvalidParameterException("Invalid id");
        }
        Optional<NailDesign> optionalNailDesign = nailDesignRepositoryJPA.findById(id);

        if(optionalNailDesign.isEmpty()){
            throw new NotFoundException("design with id " + id + " not found");
        }
        NailDesign nailDesign = optionalNailDesign.get();
        DesignResponseDTO designResponseDTO = converter.convert(nailDesign);
        nailDesignRepositoryJPA.deleteById(id);
        return designResponseDTO;
    }
}
