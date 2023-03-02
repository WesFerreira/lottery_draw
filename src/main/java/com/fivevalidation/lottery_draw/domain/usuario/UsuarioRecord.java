package com.fivevalidation.lottery_draw.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRecord(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email

) {
}
