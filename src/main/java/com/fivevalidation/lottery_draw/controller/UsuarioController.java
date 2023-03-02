package com.fivevalidation.lottery_draw.controller;

import com.fivevalidation.lottery_draw.domain.usuario.Usuario;
import com.fivevalidation.lottery_draw.domain.usuario.UsuarioRecord;
import com.fivevalidation.lottery_draw.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public String cadastrar(@RequestBody @Valid UsuarioRecord dados) {
        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        return "200";
    }

}
