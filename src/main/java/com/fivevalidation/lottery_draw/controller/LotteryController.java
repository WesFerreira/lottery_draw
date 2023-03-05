package com.fivevalidation.lottery_draw.controller;

import com.fivevalidation.lottery_draw.domain.ticket.Ticket;
import com.fivevalidation.lottery_draw.domain.ticket.TicketRecord;
import com.fivevalidation.lottery_draw.domain.usuario.Usuario;
import com.fivevalidation.lottery_draw.domain.usuario.UsuarioRecord;
import com.fivevalidation.lottery_draw.repository.TicketRepository;
import com.fivevalidation.lottery_draw.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lottery")
public class LotteryController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("ticket/cadastrar")
    public String cadastrarTicket(@RequestBody @Valid TicketRecord dados) {
        var ticket = new Ticket(dados);
        ticketRepository.save(ticket);
        return "200";
    }

    @PostMapping("usuario/cadastrar")
    public String cadastrar(@RequestBody @Valid UsuarioRecord dados) {
        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        return "200";
    }

}
