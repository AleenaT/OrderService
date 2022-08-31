package com.orderservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderservice.model.OrderDtoRequest;
import com.orderservice.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    OrderService orderService;

    @MockBean
    Controller controller;

    @Mock
    OrderDtoRequest orderDtoRequest1;

    final String FIND_ORDER = "/api/service/findOrder/" + "1";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        orderDtoRequest1  = new OrderDtoRequest();
        orderDtoRequest1.setName("apple");
        orderDtoRequest1.setQuantity(1);


    }

    @Test
    void getAllOrders() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/service/findAllOrders").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    }

    @Test
    void getOrder() throws Exception {

//        mockMvc.perform(
//                        MockMvcRequestBuilders.get(FIND_ORDER)).andExpect(status().isNoContent());
    }

    @Test
    void orderFood() throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/service/order").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(orderDtoRequest1)))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }
}