package org.nailproject.dto.clients;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestForUpdateOrCreateDTO {
    private String firstName;
    private String lastName;
    @Min(value = 25, message = "age has to be more then 25")
    private int age;
    private String email;
    private String phoneNumber;
    private Integer id;
}


