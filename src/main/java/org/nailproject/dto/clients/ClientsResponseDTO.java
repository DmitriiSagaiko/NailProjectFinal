package org.nailproject.dto.clients;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsResponseDTO {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;
    private Integer id;

}
