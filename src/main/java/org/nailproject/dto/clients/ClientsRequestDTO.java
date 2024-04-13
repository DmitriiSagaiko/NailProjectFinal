package org.nailproject.dto.clients;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsRequestDTO {

    private String firstName;

    private String lastName;

    private int age;
    private String email;

}
