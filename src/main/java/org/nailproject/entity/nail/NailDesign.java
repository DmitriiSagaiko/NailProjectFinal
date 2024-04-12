package org.nailproject.entity.nail;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.nailproject.entity.client.Client;

import java.util.List;

@Data
@Entity
public class NailDesign {

    @NotNull
    @NotEmpty(message = "Name is mandatory")
    private String name;


    @Size(min = 1, max = 10, message = "stickers lie in range from 1 to 10")
    private Integer amountOfStickers;


    @NotEmpty
    private Boolean isPublic;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotEmpty(message = "client has to be assigned")
    @ManyToOne
    @JoinColumn(name = "client_nail_design")
    private Client client;
}
