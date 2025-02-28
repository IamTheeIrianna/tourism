package com.example.tourism.controller;

import com.example.tourism.model.TouristAttraction;
import com.example.tourism.service.TouristService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    private TouristService touristService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTourAttractionsList() {
    }

    @Test
    void getTourAttractionName() {
    }

    @Test
    void addAttraction()throws Exception{
        mockMvc.perform(post("/attractions/add")
                .param("name", "tivoli")
                .param("name", "kongens have"))
                .andExpect(status().isOk());



    }

    @Test
    void deleteAttraction() {
    }

    @Test
    void updateAttraction() {
    }
}