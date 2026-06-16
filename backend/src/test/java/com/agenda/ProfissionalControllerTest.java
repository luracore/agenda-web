package com.agenda;

import com.agenda.controller.ProfissionalController;
import com.agenda.model.Profissional;
import com.agenda.repository.ProfissionalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * TESTES UNITÁRIOS - Profissionais
 */
@WebMvcTest(ProfissionalController.class)
class ProfissionalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfissionalRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarProfissionalComSucesso() throws Exception {
        Profissional profissional = new Profissional();
        profissional.setId(1L);
        profissional.setNome("João Silva");
        profissional.setTelefone("31999999999");
        profissional.setEndereco("Rua A");
        profissional.setCategoria("MEDICO");

        when(repository.save(any(Profissional.class))).thenReturn(profissional);

        mockMvc.perform(post("/api/profissionais")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(profissional)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("João Silva"));
    }

    @Test
    void deveListarProfissionaisVazio() throws Exception {
        when(repository.findAll()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/api/profissionais"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void deveRetornar404ParaProfissionalInexistente() throws Exception {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/profissionais/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deveDeletarProfissionalComSucesso() throws Exception {
        Profissional profissional = new Profissional();
        profissional.setId(1L);
        profissional.setNome("João Silva");

        when(repository.findById(1L)).thenReturn(Optional.of(profissional));

        mockMvc.perform(delete("/api/profissionais/1"))
                .andExpect(status().isOk());
    }
}
