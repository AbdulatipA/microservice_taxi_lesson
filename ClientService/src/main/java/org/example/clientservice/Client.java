package org.example.clientservice;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;
    private String password;
    private double money;

    @Column(length = 11, nullable = false, unique = true)
    private String phone;
}
