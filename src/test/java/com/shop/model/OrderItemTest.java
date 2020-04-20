package com.shop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    static final String TEST_123 = "test123";

    @Test
    void testObjectOrderItem() {
        final OrderItem orderItem = new OrderItem(1L, TEST_123);
        assertEquals(1L, orderItem.getId());
        assertEquals(TEST_123, orderItem.getName());
    }

}