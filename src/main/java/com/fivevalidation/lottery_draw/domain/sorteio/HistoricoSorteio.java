package com.fivevalidation.lottery_draw.domain.sorteio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "historico_sorteio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HistoricoSorteio {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String numerosSorteados;

}
