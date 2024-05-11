package com.example.periferiaback.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.periferiaback.enums.TipoDocumentoEnum;
import com.example.periferiaback.models.Usuario;

@Service
public class UsuarioService {
    private List<Usuario> users = new ArrayList<Usuario>();

    private UsuarioService() {
        this.inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        this.users.add(
                new Usuario(1L, "Juan", "Pablo", "Perez", "Sanchez", "123456789", "Calle 123", "Ciudad A",
                        TipoDocumentoEnum.C,
                        23445322L));
        this.users.add(
                new Usuario(2L, "Maria", "Angelica", "Gonzalez", "Martinez", "987654321", "Carrera 456", "Ciudad B",
                        TipoDocumentoEnum.P,
                        87654321L));
    }

    public List<Usuario> getUsers() {
        return this.users;
    }

    public Optional<Usuario> getUserByTipoDocumentoAndNumeroDocumento(TipoDocumentoEnum tipoDocumento,
            Long numeroDocumento) {
        return this.users.stream()
                .filter(usuario -> usuario.getTipoDocumento() == tipoDocumento
                        && usuario.getNumeroDocumento().equals(numeroDocumento))
                .findFirst();
    }

}