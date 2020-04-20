package com.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest

@WebAppConfiguration
@ContextConfiguration
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderControllerTestIT {


    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getOrders() throws Exception {

    }

    @Test
    void shouldReturnBodyWhenRequestIsCorrect() throws Exception {
        // given
        final MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                        .characterEncoding("utf-8")
        )
        .andDo(print())
        .andReturn();

        // then
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals("[{\"id\":1,\"name\":\"first item\"},{\"id\":2,\"name\":\"second item\"},{\"id\":3,\"name\":\"last item\"}]", mvcResult.getResponse().getContentAsString());
    }
}