package org.temkarus0070.payservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.temkarus0070.payservice.models.Order;
import org.temkarus0070.payservice.models.Status;

import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PaymentControllerTest {


    private MockMvc mockMvc;
    private ObjectMapper objectMapper;


    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void test() throws Exception {
        Order order = new Order("Pupkin", 44, new ArrayList<>(), Status.NEW);
        String json = objectMapper.writeValueAsString(order);


        final String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/payment")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();


        final Order order1 = objectMapper.readValue(contentAsString, Order.class);


        Assertions.assertTrue(order1 != null && (order1.getStatus() == Status.CANCELLED || order1.getStatus() == Status.PURCHASED));

        order1.setStatus(order.getStatus());


        Assertions.assertEquals(order1, order);
    }
}
