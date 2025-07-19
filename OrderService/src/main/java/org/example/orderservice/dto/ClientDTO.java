package org.example.orderservice.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String fullName;
    private double money;
    private String phone;
}
