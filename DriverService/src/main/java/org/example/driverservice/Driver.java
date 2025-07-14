package org.example.driverservice;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;
    private String password;
    private String experience;
    private int stars;
}
