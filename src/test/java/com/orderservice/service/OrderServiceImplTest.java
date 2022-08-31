package com.orderservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderservice.model.OrderDtoRequest;
import com.orderservice.model.OrderDtoResponse;
import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderServiceImpl.class)
class OrderServiceImplTest {

    @MockBean
    OrderService orderService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    OrderDtoResponse orderDtoResponse;

    OrderDtoRequest orderDtoRequest;

    @Before
    public void setUp() {
        this.orderDtoRequest.setName("apple");
        this.orderDtoRequest.setQuantity(2);
//        this.orderDtoRequest.setId(1);
    }

    @Test
    void saveOrder() throws Exception {
        OrderDtoRequest validRequest = this.orderDtoRequest;
      //  validRequest.setId(null);

        String validRequestJson = objectMapper.writeValueAsString(validRequest);


        mockMvc.perform(post("/api/service/order").contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(validRequestJson))).andExpect(status().isOk());

    }

    @Test
    void getAllOrders() {
    }

    @Test
    void getOrder() {
    }

    @Test
    void findCostofFruit() {
    }

    @Test
    void findQuantityAfterSale() {
    }
}