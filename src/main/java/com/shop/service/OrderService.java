package com.shop.service;

import com.shop.model.OrderItem;
import com.shop.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderItem> list() {
        return orderRepository.findAll();
    }
}