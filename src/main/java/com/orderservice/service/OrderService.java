package com.orderservice.service;

import com.orderservice.model.OrderDtoRequest;
import com.orderservice.model.OrderDtoResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public void saveOrder(OrderDtoRequest orderDtoRequest);
    public List<OrderDtoResponse> getAllOrders();

    public Optional<OrderDtoResponse> getOrder(Long id);
}
