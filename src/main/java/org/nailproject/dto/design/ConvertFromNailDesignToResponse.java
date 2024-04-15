package org.nailproject.dto.design;

import lombok.Data;
import org.nailproject.entity.nail.NailDesign;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConvertFromNailDesignToResponse {
    public DesignResponseDTO convert(NailDesign design) {
        DesignResponseDTO dto = new DesignResponseDTO();
        dto.setName(design.getName());
        dto.setClientId(design.getClient().getId());
        dto.setIsPublic(design.getIsPublic());
        dto.setAmountOfStickers(design.getAmountOfStickers());
        dto.setDesignId(design.getId());
        return dto;
    }
}
