package org.nailproject.entity.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Client {

    private String firstName;

    private String lastname;

    private int age;

    private String email;

    private String phoneNumber;
}
