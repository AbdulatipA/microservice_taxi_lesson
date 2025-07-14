package org.example.orderservice.controller;

import lombok.AllArgsConstructor;
import org.example.orderservice.Order;
import org.example.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order clientSaved = orderService.create(order);
        return ResponseEntity.ok(clientSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable long id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        orderService.deleteById(id);
        return ResponseEntity.ok("Пользователь удален");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateById(@PathVariable long id, @RequestBody Order driver) {
        return ResponseEntity.ok(orderService.update(id, driver));
    }
}
