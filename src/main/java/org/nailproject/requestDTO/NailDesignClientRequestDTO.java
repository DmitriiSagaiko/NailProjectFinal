package org.nailproject.requestDTO;

import lombok.Data;
import org.nailproject.entity.client.Client;
import org.nailproject.entity.nail.NailDesign;

@Data
public class NailDesignClientRequestDTO {
    private NailDesign design;
    private Client client;
}
