package com.fivevalidation.lottery_draw.repository;

import com.fivevalidation.lottery_draw.domain.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository <Ticket, Long> {
    List<Ticket> findByEmail(String email);

    List<Ticket> findByNumero(String numero);

    @Query("SELECT t FROM Ticket t WHERE "
            + "t.numero LIKE %:numero1% AND "
            + "t.numero LIKE %:numero2% AND "
            + "t.numero LIKE %:numero3% AND "
            + "t.numero LIKE %:numero4% AND "
            + "t.numero LIKE %:numero5%")
    List<Ticket> findTicketsByNumerosSorteados(
            @Param("numero1") String numero1,
            @Param("numero2") String numero2,
            @Param("numero3") String numero3,
            @Param("numero4") String numero4,
            @Param("numero5") String numero5);
}
