package org.nailproject.entity.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Client {

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private String phoneNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
