package br.jus.tjba.api.push.usuario.repository;

import br.jus.tjba.api.push.usuario.model.UsuarioProcessoSistemaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioProcessoSistemaRepository extends JpaRepository<UsuarioProcessoSistemaModel, Long> {
    @Query(value = "SELECT *" +
            "FROM usuario_processo_sistema ups " +
            "WHERE ups.id_usuario = :id_usuario " +
            "AND ups.id_sistema= :id_sistema " +
            "AND ups.numero_processo= :numero_processo", nativeQuery = true)
    public Optional<UsuarioProcessoSistemaModel> findByUsuarioProcessoSistema(Long id_usuario,
                                                                              Long id_sistema,
                                                                              String numero_processo);
    @Query(value = "SELECT *" +
            "FROM usuario_processo_sistema ups " +
            "WHERE ups.id_sistema= :id_sistema  " +
            "AND ups.numero_processo= :numero_processo", nativeQuery = true)
    public List<UsuarioProcessoSistemaModel> findByAssociados(Long id_sistema, String numero_processo);
}
