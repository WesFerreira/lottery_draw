package com.fivevalidation.lottery_draw.domain;

import jakarta.validation.constraints.NotBlank;

public record TicketRecord(

        @NotBlank
        String nomeUsuario,
        @NotBlank
        String numero) {
}
