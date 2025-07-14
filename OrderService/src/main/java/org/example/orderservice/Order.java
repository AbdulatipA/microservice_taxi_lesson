package org.example.orderservice;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime orderDate;
    private double price;
    private String startPoint;
    private String endPoint;
    private String driverName;
    private String clientName;
}
