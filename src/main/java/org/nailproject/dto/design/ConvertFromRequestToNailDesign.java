package org.nailproject.dto.design;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nailproject.entity.nail.NailDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConvertFromRequestToNailDesign {
    public NailDesign convertFromRequestToNailDesign(DesignRequestDTO requestDTO) {
        NailDesign nailDesign = new NailDesign();
        if (requestDTO.getName() != null){
            nailDesign.setName(requestDTO.getName());
        }
        if (requestDTO.getClientId()>0){
            nailDesign.setId(requestDTO.getClientId());
        }
        if (requestDTO.getAmountOfStickers()>0 && requestDTO.getAmountOfStickers()<11){
            nailDesign.setAmountOfStickers(requestDTO.getAmountOfStickers());
        }
        nailDesign.setIsPublic(requestDTO.getIsPublic());
        return nailDesign;
    }
}
