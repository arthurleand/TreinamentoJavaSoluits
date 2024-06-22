package br.jus.tjba.api.push.usuario.repository;

import br.jus.tjba.api.push.usuario.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
