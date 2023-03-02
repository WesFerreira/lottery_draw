package com.fivevalidation.lottery_draw.controller;

import com.fivevalidation.lottery_draw.domain.Ticket;
import com.fivevalidation.lottery_draw.domain.TicketRecord;
import com.fivevalidation.lottery_draw.repository.TicketRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping
    public String cadastrar(@RequestBody @Valid TicketRecord dados) {
        var ticket = new Ticket(dados);
        ticketRepository.save(ticket);
        return "200";
    }
}
