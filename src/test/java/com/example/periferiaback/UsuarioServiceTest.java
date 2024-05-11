package com.example.periferiaback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.periferiaback.enums.TipoDocumentoEnum;
import com.example.periferiaback.models.Usuario;
import com.example.periferiaback.services.UsuarioService;

@SpringBootTest
public class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testGetUsers() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario(1L, "Juan", "Pablo", "Perez", "Sanchez", "123456789", "Calle 123", "Ciudad A",
                TipoDocumentoEnum.C,
                23445322L));
        usuarios.add(
                new Usuario(2L, "Maria", "Angelica", "Gonzalez", "Martinez", "987654321", "Carrera 456", "Ciudad B",
                        TipoDocumentoEnum.P,
                        87654321L));

        List<Usuario> resultado = usuarioService.getUsers();

        assertEquals(usuarios.size(), resultado.size());
    }

    @Test
    public void testGetUserByTipoDocumentoAndNumeroDocumento() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "Juan", "Pablo", "Perez", "Sanchez", "123456789", "Calle 123", "Ciudad A",
                TipoDocumentoEnum.C,
                23445322L));
        usuarios.add(
                new Usuario(2L, "Maria", "Angelica", "Gonzalez", "Martinez", "987654321", "Carrera 456", "Ciudad B",
                        TipoDocumentoEnum.P,
                        87654321L));

        Optional<Usuario> resultado = usuarioService.getUserByTipoDocumentoAndNumeroDocumento(TipoDocumentoEnum.C,
                23445322L);

        assertNotNull(resultado.get());
    }
}
