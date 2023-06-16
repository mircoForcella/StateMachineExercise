package com.statemachine.demo.controllers;

import com.statemachine.demo.entities.Order;
import com.statemachine.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        orderService.startProcessing(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PostMapping("/{orderId}/complete")
    public ResponseEntity<Order> completeOrder(@PathVariable("orderId") Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        orderService.completeOrder(order);

        return ResponseEntity.ok(order);
    }

    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable("orderId") Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        orderService.cancelOrder(order);

        return ResponseEntity.ok(order);
    }

}