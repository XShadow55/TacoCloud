package com.example.Taco_Cloud.controller;

import static org.hamcrest.Matchers.containsString;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest()
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePageTest() throws Exception{
        mockMvc.perform(get("/")) //Выполнить запрос get
                .andExpect(status().isOk()) //Ожидаем код ответа 200
                .andExpect(view().name("home"))//Имя представления home
                .andExpect(content().string(containsString("Welcome to...")));// Наличие строки
    }
}
