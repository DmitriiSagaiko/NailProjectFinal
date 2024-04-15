package org.nailproject.entity.nail;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.nailproject.entity.client.Client;

import java.util.List;

@Data
@Entity
public class NailDesign {

    @NotNull(message = "name can't be null")
    @NotEmpty(message = "Name is mandatory")
    private String name;


    @Min(value = 1, message = "min amount of stickers has to be more then 1")
    @Max(value = 10, message = "maximum amount of stickers has to less then 11")
    private int amountOfStickers;


    private Boolean isPublic;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "client can't be null")
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
}
