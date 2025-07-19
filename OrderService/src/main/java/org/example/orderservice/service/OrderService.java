package org.example.orderservice.service;

import lombok.AllArgsConstructor;
import org.example.orderservice.DriverClient;
import org.example.orderservice.Order;
import org.example.orderservice.UserClient;
import org.example.orderservice.dto.ClientDTO;
import org.example.orderservice.dto.DriverDTO;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private UserClient userClient;
    private DriverClient driverClient;


    public ResponseEntity<?> create(Order order) {
        ResponseEntity<ClientDTO> responseClient = userClient.getClient(order.getClientId());
        if(!responseClient.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().build();
        }


        ResponseEntity<DriverDTO> responseDriver = driverClient.getDriver(order.getDriverId());

        if(!responseDriver.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().build();
        }

        DriverDTO driverDTO = responseDriver.getBody();
        if(!driverDTO.isStatus()) {
            System.out.println("Водитель не может он занят");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Водитель занят");
        }
        driverClient.editStatus(responseDriver.getBody().getId(), false);
        order.setOrderDate(LocalDateTime.now());


        return ResponseEntity.ok(orderRepository.save(order));
    }


    public Order getById(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    public Order update(long id, Order order) {
        Order updateOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

        updateOrder.setStartPoint(order.getStartPoint());
        updateOrder.setEndPoint(order.getEndPoint());

        return orderRepository.save(updateOrder);
    }
}
