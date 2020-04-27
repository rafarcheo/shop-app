package com.shop.service;

import com.shop.model.OrderItem;
import com.shop.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderItem> list() {
        return orderRepository.findAll();
    }

    public List<OrderItem> addNew() {
        final int size = orderRepository.findAll().size();
        final OrderItem newOrder = new OrderItem(null, "new item " + size);
        final ArrayList<OrderItem> newOrders = new ArrayList<OrderItem>();
        newOrders.add(newOrder);
        return orderRepository.saveAll(newOrders);
    }
}