package com.example.periferiaback;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getByTipoDocumentoAndNumeroDocumento() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/usuarios/getByTipoDocumentoAndNumeroDocumento?tipoDocumento=C&numeroDocumento=23445322")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getByTipoDocumentoAndNumeroDocumentoNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/usuarios/getByTipoDocumentoAndNumeroDocumento?tipoDocumento=C&numeroDocumento=2344532")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void getByTipoDocumentoAndNumeroDocumentoBad() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/usuarios/getByTipoDocumentoAndNumeroDocumento?tipoDocumento=C")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
