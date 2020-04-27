package com.shop.controller;

import com.shop.model.OrderItem;
import com.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value=OrderController.ORDER)
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    static final String ORDER = "/order";

    private final OrderService orderService;

    @GetMapping
    public List<OrderItem> findAll() {
        log.info("[order controller] try display all orders");
        return orderService.list();
    }

    @PutMapping
    public List<OrderItem> putOrder() {
        log.info("[order controller] try put new order");
        return orderService.addNew();
    }

}
