package org.nailproject.dto.design;

import lombok.Data;

@Data
public class DesignResponseDTO {

    private String name;
    private Integer amountOfStickers;
    private Boolean isPublic;
    private Integer clientId;

}
