package com.example.periferiaback.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.periferiaback.enums.TipoDocumentoEnum;
import com.example.periferiaback.models.Usuario;
import com.example.periferiaback.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/getAll")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsers();
    }

    @GetMapping("/getByTipoDocumentoAndNumeroDocumento")
    public Optional<Usuario> getByTipoDocumentoAndNumeroDocumento(
            @RequestParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,
            @RequestParam("numeroDocumento") Long numeroDocumento) {
        return this.usuarioService.getUserByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
    }
}
