package com.fivevalidation.lottery_draw.repository;

import com.fivevalidation.lottery_draw.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
}
