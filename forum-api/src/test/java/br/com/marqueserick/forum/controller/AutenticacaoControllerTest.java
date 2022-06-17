package br.com.marqueserick.forum.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveRetornarBadRequestCasoEmailSenhaInvalidos() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\"email\": \"invalido@email.com\",\"senha\":\"123\"}";
        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .contentType("application/json")
                .content(json))
                .andExpect(status().isBadRequest());
    }
}