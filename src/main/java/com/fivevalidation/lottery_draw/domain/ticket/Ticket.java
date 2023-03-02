package com.fivevalidation.lottery_draw.domain.ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ticket {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeUsuario;
    private String numero;

    public Ticket(TicketRecord dados) {
        this.nomeUsuario = dados.nomeUsuario();
        this.numero = dados.numero();
    }
}
