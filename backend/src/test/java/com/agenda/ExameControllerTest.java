package com.agenda;

import com.agenda.controller.ExameController;
import com.agenda.model.Exame;
import com.agenda.repository.ExameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExameController.class)
class ExameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExameRepository repository;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void deveCriarExameComSucesso() throws Exception {
        Exame ex = new Exame();
        ex.setId(1L);
        ex.setDescricao("Exame de sangue");
        ex.setLink("http://exame.com");
        ex.setPosologia("Jejum de 12h");

        when(repository.save(any(Exame.class))).thenReturn(ex);

        mockMvc.perform(post("/api/exames")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ex)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.descricao").value("Exame de sangue"));
    }

    @Test
    void deveListarExames() throws Exception {
        Exame ex1 = new Exame();
        ex1.setId(1L);
        ex1.setDescricao("Exame 1");

        Exame ex2 = new Exame();
        ex2.setId(2L);
        ex2.setDescricao("Exame 2");

        when(repository.findAll())
                .thenReturn(Arrays.asList(ex1, ex2));

        mockMvc.perform(get("/api/exames"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].descricao").value("Exame 1"))
                .andExpect(jsonPath("$[1].descricao").value("Exame 2"));
    }

    @Test
    void deveRetornar404ParaExameInexistente() throws Exception {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/exames/999"))
                .andExpect(status().isNotFound());
    }
}
