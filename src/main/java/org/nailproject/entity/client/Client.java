package org.nailproject.entity.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Client {
    @NotNull(message = "firstName has to be assigned")
    @Min(value = 5, message = "first name has to be longer then 5 symbols")
    private String firstName;


    @NotNull(message = "lastName has to be assigned")
    @Min(value = 5, message = "last name has to be longer then 5 symbols")
    private String lastName;


    @Digits(integer = 3, fraction = 0, message = "Age has to be in range from 0 to 150")
    @Max(value = 150, message ="Age has to be less then 150" )
    @Positive
    private int age;

    @Email
    private String email;

    @Size(min = 9, max = 16)
    @NotNull
    @NotEmpty
    private String phoneNumber;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
