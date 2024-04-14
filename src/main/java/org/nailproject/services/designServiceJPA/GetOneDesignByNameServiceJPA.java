package org.nailproject.services.designServiceJPA;

import exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.nailproject.dto.design.ConvertFromNailDesignToResponse;
import org.nailproject.dto.design.DesignResponseDTO;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetOneDesignByNameServiceJPA {
    private final NailDesignRepositoryJPA nailDesignRepository;
    private final ConvertFromNailDesignToResponse convertFromNailDesignToResponse;




    public DesignResponseDTO getOneDesignByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Optional<NailDesign> optionalNailDesign = nailDesignRepository.getNailDesignByName(name);
        if(optionalNailDesign.isEmpty()){
            throw new NotFoundException("Nail Design with name " + name + " was not Found");
        }
       return convertFromNailDesignToResponse.convert(optionalNailDesign.get());

    }
}
