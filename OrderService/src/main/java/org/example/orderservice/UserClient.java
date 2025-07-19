package org.example.orderservice;

import lombok.AllArgsConstructor;
import org.example.orderservice.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<ClientDTO> getClient(long id) {
        try {
            return restTemplate.getForEntity("http://localhost:8080/clients/{id}", ClientDTO.class, id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
