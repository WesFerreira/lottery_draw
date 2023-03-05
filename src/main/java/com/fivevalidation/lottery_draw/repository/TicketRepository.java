package com.fivevalidation.lottery_draw.repository;

import com.fivevalidation.lottery_draw.domain.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository <Ticket, Long> {
    List<Ticket> findByEmail(String email);
}
