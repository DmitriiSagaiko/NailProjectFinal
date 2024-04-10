package org.nailproject.entity.nail;

import jakarta.persistence.*;
import lombok.Data;
import org.nailproject.entity.client.Client;

import java.util.List;

@Data
@Entity
public class NailDesign {

    private String name;
    private Integer amountOfStickers;


    private Boolean isPublic;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_nail_design")
    private Client client;
}
