package org.nailproject.entity.nail;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class NailTag {
    private String name;
    @ManyToOne
    @JoinColumn(name = "nail_design_tag")
    private NailDesign nailDesign;

}
