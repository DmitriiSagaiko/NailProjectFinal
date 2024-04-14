package org.nailproject.services.designServiceJPA;

import exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.nailproject.dto.design.ConvertFromNailDesignToResponse;
import org.nailproject.dto.design.ConvertFromRequestToNailDesign;
import org.nailproject.dto.design.DesignRequestDTO;
import org.nailproject.dto.design.DesignResponseDTO;
import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.ClientRepositoryJPA;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.nailproject.requestDTO.NailDesignClientRequestDTO;
import org.nailproject.services.clientServiceJPA.FindClientByIdServiceJPA;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AddDesignServiceJPA {
    private final NailDesignRepositoryJPA nailDesignRepositoryJPA;
    private final ConvertFromRequestToNailDesign convertFromRequestToNailDesign;
    private final FindClientByIdServiceJPA findClientByIdServiceJPA;
    private final ConvertFromNailDesignToResponse convertFromNailDesignToResponse;

    public DesignResponseDTO addNailDesign(DesignRequestDTO requestDTO) {

        Optional<Client> optionalClient = findClientByIdServiceJPA.findClientById(requestDTO.getClientId());

        if(optionalClient.isEmpty()){
            throw new NotFoundException("Client with id " + requestDTO.getClientId() + " not found");
        }

        NailDesign design = convertFromRequestToNailDesign.convertFromRequestToNailDesign(requestDTO);
        design.setClient(optionalClient.get());

        NailDesign afterSave = nailDesignRepositoryJPA.save(design);


        return convertFromNailDesignToResponse.convert(afterSave);
    }
}
