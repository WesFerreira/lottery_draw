package com.fivevalidation.lottery_draw.domain.sorteio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historico_sorteio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HistoricoSorteio {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String numerosSorteados;
    private String idSorteio;

}
