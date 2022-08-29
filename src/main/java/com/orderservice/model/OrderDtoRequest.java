package com.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;

public class OrderDtoRequest {

    @JsonIgnore
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private int quantity;
    @JsonIgnore
    private double cost;

    public OrderDtoRequest(Long id, String name, int quantity, double cost) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public OrderDtoRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
