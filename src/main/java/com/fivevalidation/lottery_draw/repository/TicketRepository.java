package com.fivevalidation.lottery_draw.repository;

import com.fivevalidation.lottery_draw.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, Long> {

}