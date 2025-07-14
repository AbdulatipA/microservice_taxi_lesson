package org.example.orderservice.service;

import lombok.AllArgsConstructor;
import org.example.orderservice.Order;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public Order create(Order order) {
        return orderRepository.save(order);
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
