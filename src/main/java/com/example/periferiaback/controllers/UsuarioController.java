package com.example.periferiaback.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService;

    /**
     * GET Metodo para obtener todos los usuarios
     * 
     * @return
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        logger.info("Metodo GET para obtener todos los usuarios");
        return ResponseEntity.ok(usuarioService.getUsers());
    }

    /**
     * GET Metodo para obtener un usuario por tipo de documento y numero de
     * documento
     * 
     * @param tipoDocumento
     * @param numeroDocumento
     * @return
     */
    @GetMapping("/getByTipoDocumentoAndNumeroDocumento")
    public ResponseEntity<Usuario> getByTipoDocumentoAndNumeroDocumento(
            @RequestParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,
            @RequestParam("numeroDocumento") Long numeroDocumento) {
        logger.info("Metodo GET para obtener el usuario con tipo de documento " + tipoDocumento
                + " y el numero de docuemnto " + numeroDocumento);
        Optional<Usuario> usuario = this.usuarioService.getUserByTipoDocumentoAndNumeroDocumento(tipoDocumento,
                numeroDocumento);

        // Si se encuentra al usuario
        if (usuario.isPresent()) {
            logger.info("Se encontro el usuario");
            return ResponseEntity.ok(usuario.get());
        } else {
            logger.info("No se encontro el usuario");
            return ResponseEntity.notFound().build();
        }
    }
}
