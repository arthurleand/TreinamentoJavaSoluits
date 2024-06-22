package br.jus.tjba.api.push.usuario.repository;

import br.jus.tjba.api.push.usuario.model.UsuarioProcessoSistemaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioProcessoSistemaRepository extends JpaRepository<UsuarioProcessoSistemaModel, Long> {
}
