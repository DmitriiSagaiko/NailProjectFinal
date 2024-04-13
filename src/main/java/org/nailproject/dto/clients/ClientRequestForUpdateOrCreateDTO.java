package org.nailproject.dto.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestForUpdateOrCreateDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;
    private Integer id;
}
