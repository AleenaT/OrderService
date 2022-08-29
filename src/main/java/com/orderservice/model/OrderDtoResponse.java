package com.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;

public class OrderDtoResponse {

    private Long id;
    private String name;
    private int quantityAfterSale;
    private double cost;

    public OrderDtoResponse(Long id, String name, int quantityAfterSale, double cost) {
        this.id = id;
        this.name = name;
        this.quantityAfterSale = quantityAfterSale;
        this.cost = cost;
    }

    public OrderDtoResponse() {
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

    public int getQuantityAfterSale() {
        return quantityAfterSale;
    }

    public void setQuantityAfterSale(int quantity) {
        this.quantityAfterSale = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
