package com.orangetalents.desafio.repository;

import com.orangetalents.desafio.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String id);
}
