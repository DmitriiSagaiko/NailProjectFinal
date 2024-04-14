package org.nailproject.dto.design;

import lombok.Data;
import org.nailproject.entity.client.Client;

@Data
public class DesignRequestDTO {

    private String name;
    private Integer amountOfStickers;
    private Boolean isPublic;
    private Integer clientId;

}
