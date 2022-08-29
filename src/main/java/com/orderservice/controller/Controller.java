package com.orderservice.controller;

import com.orderservice.model.OrderDtoRequest;
import com.orderservice.model.OrderDtoResponse;
import com.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/service")
public class Controller {
    private OrderService orderService;

    @Autowired
    public Controller(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/findAllOrders")
    public ResponseEntity<List<OrderDtoResponse>> getAllOrders(){

        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping(value = "/findOrder/{id}")
    public ResponseEntity<Optional<OrderDtoResponse>> getOrder(@RequestParam(required = true)@PathVariable("id") Long orderId){

        return new ResponseEntity<>(orderService.getOrder(orderId),HttpStatus.OK);
    }

    @PostMapping(value = "/order")
    public ResponseEntity<OrderDtoResponse> orderFood(@RequestBody OrderDtoRequest orderDtoRequest){
        orderService.saveOrder(orderDtoRequest);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}
