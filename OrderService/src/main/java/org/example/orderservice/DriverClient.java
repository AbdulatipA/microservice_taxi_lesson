package org.example.orderservice;

import lombok.AllArgsConstructor;
import org.example.orderservice.dto.DriverDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Driver;

@Service
@AllArgsConstructor
public class DriverClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<DriverDTO> getDriver(long id) {
        try {
           return restTemplate.getForEntity("http://localhost:8181/drivers/{id}", DriverDTO.class, id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<String> editStatus(long idDriver, Boolean status) {
        try {
            String url ="http://localhost:8181/drivers/statusDriver/{id}?statusDriver={status}";
            restTemplate.put(url,null, idDriver, status);
            return ResponseEntity.ok("Статус водителя обновлен");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
