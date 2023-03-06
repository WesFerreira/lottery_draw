package com.fivevalidation.lottery_draw.domain.ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    private String email;

    private BigDecimal preçoLiquido;

    private BigDecimal preçoBruto;

    public Ticket(TicketRecord dados) {
        this.nomeUsuario = dados.nomeUsuario();
        this.numero = dados.numero();
        this.email = dados.email();
    }

    public Ticket(String nomeUsuario, String numero, String email) {
        this.nomeUsuario = nomeUsuario;
        this.numero = numero;
        this.email = email;
    }
}
