package com.orderservice.service;

import com.orderservice.entity.OrderEntity;
import com.orderservice.model.OrderDtoRequest;
import com.orderservice.model.OrderDtoResponse;
import com.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(OrderDtoRequest orderDtoRequest) {
    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setName(orderDtoRequest.getName());
    orderEntity.setQuantity(orderDtoRequest.getQuantity());
    orderEntity.setCost(findCostofFruit(orderDtoRequest));
    orderRepository.save(orderEntity);

    }

    @Override
    public List<OrderDtoResponse> getAllOrders() {
        List<OrderDtoResponse> dtoList = new ArrayList<>();
        List<OrderEntity> entityList = new ArrayList<>();
        entityList = orderRepository.findAll();

        for(int i =0; i < entityList.size(); i++) {
            OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
            orderDtoResponse.setId(entityList.get(i).getId());
            orderDtoResponse.setName(entityList.get(i).getName());
            orderDtoResponse.setCost(entityList.get(i).getCost());
            orderDtoResponse.setQuantity(entityList.get(i).getQuantity());
            dtoList.add(orderDtoResponse);
        }


        return dtoList;
    }

    @Override
    public Optional<OrderDtoResponse> getOrder(Long id) {
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();

        Optional<OrderEntity> orderEntity = orderRepository.findById(id);

        orderEntity.ifPresentOrElse(order -> {
            orderDtoResponse.setId((order.getId()));
            orderDtoResponse.setName(order.getName());
            orderDtoResponse.setQuantity(order.getQuantity());
            orderDtoResponse.setCost(order.getCost());
        }, () -> {
            throw new RuntimeException("No record found, sorry!");
        });

    return Optional.of(orderDtoResponse);
    }

    public double findCostofFruit(OrderDtoRequest orderDtoRequest) {

        if(orderDtoRequest.getName().toLowerCase().equals("apple")){
            return 0.60 * orderDtoRequest.getQuantity();
        }
        else if (orderDtoRequest.getName().toLowerCase().equals("orange")){
            return 0.25 * orderDtoRequest.getQuantity();
        }

        return 0;
    }

}
