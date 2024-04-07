package org.nailproject.entity.nail;

import lombok.Data;

import java.util.List;

@Data
public class NailDesign {
    private List<NailTag> tags;
    private String name;
    private Integer amountOfStickers;
    private List<NailSticker> stickers;
    private Boolean isPublic;
}
