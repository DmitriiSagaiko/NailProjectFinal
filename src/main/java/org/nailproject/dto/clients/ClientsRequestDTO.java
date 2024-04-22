package org.nailproject.dto.clients;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsRequestDTO {

    @NotNull(message = "firstName has to be assigned")
    @Size(min = 3, message = "first name has to be longer then 3 symbols")
    private String firstName;


    @NotNull(message = "lastName has to be assigned")
    @Size(min = 3, message = "last name has to be longer then 3 symbols")
    private String lastName;


    @Digits(integer = 3, fraction = 0, message = "Age has to be in range from 0 to 150")
    @Max(value = 150, message ="Age has to be less then 150" )
    @Positive(message = "age has to be greater then 0")
    private int age;

    @Email(message = "provide correct email for example user@domain.com")
    private String email;

}
