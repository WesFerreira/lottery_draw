package com.fivevalidation.lottery_draw.domain.ticket;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public record TicketRecord(

        @NotBlank
        String nomeUsuario,
        @NotBlank
        String numero,
        @NotBlank @Email
        String email) {
}
