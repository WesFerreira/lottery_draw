package com.fivevalidation.lottery_draw.repository;

import com.fivevalidation.lottery_draw.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    List<Usuario> findByEmail(String email);
}
