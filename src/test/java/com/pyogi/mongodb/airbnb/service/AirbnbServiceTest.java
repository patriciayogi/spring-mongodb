package com.pyogi.mongodb.airbnb.service;

import com.pyogi.mongodb.airbnb.controller.AirbnbController;
import com.pyogi.mongodb.airbnb.model.ListingsAndReviews;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AirbnbController.class)
public class AirbnbServiceTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AirbnbService airbnbService;

    @Before
    public void setup() {
        given(this.airbnbService.
                listByName("New York City - Upper West Side Apt")
        ).willReturn(
                List.of(getListingsAndReviews()));
    }

    private static ListingsAndReviews getListingsAndReviews() {
        return ListingsAndReviews.builder().name("New York City - Upper West Side Apt")._id("1").build();
    }

    @Test
    public void listByName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/airbnb/name")
                        .param("name", "New York City - Upper West Side Apt")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0]name", equalTo("New York City - Upper West Side Apt")))
                .andExpect(jsonPath("[0]_id", equalTo("1")));
    }

}