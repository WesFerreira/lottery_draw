package com.fivevalidation.lottery_draw.domain.ticket;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
@Getter
@Setter
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

    private String idSorteio;

    public Ticket(TicketRecord dados) {
        this.nomeUsuario = dados.nomeUsuario();
        this.numero = dados.numero();
        this.email = dados.email();
    }

//    public Ticket(String nomeUsuario, String numero, String email) {
//        this.nomeUsuario = nomeUsuario;
//        this.numero = numero;
//        this.email = email;
//    }
}
