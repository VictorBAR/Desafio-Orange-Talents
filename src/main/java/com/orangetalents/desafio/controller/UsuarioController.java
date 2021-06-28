package com.orangetalents.desafio.controller;

import com.orangetalents.desafio.dto.request.requestUsuarioDTO;
import com.orangetalents.desafio.entity.Usuario;
import com.orangetalents.desafio.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> inserirUsuario(@Valid @RequestBody requestUsuarioDTO usuario){
        return new ResponseEntity(usuarioService.cadastrarUsuario(usuario), HttpStatus.CREATED);
    }
}
