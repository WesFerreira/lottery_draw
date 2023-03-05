package com.fivevalidation.lottery_draw.controller;

import com.fivevalidation.lottery_draw.domain.ticket.Ticket;
import com.fivevalidation.lottery_draw.domain.ticket.TicketRecord;
import com.fivevalidation.lottery_draw.domain.usuario.Usuario;
import com.fivevalidation.lottery_draw.domain.usuario.UsuarioRecord;
import com.fivevalidation.lottery_draw.repository.TicketRepository;
import com.fivevalidation.lottery_draw.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lottery")
public class LotteryController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("ticket/cadastrar")
    public String cadastrarTicket(@RequestBody @Valid TicketRecord dadosTicket) {
        var ticket = new Ticket(dadosTicket);
        ticketRepository.save(ticket);
        return "200";
    }

    @PostMapping("usuario/cadastrar")
    public String cadastrar(@RequestBody @Valid UsuarioRecord dadosUsuario) {
        var usuario = new Usuario(dadosUsuario);
        usuarioRepository.save(usuario);
        return "200";
    }

    @GetMapping("ticket/listar")
    public List<Ticket> listarTicket(@RequestParam ("email") String email) {
        return ticketRepository.findByEmail(email);
    }

    @GetMapping("usuario/listar")
    public List<Usuario> listarUsuario(@RequestParam ("email") String email, @RequestParam("senha") String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }

}
