package com.fivevalidation.lottery_draw.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate dataHora;

}
