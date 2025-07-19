package org.example.orderservice.dto;

import lombok.Data;

@Data
public class DriverDTO {
    private Long id;
    private String fullName;
    private boolean status;
}
