package br.jus.tjba.api.push.usuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UsuarioProcessoSistemaModel.class)
@Entity(name = "UsuarioProcessoSistema)")
@Table(name = "usuario_processo_sistema")
public class UsuarioProcessoSistemaModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioModel id_usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_sistema")
    private SistemaModel id_sistema;

    @NotBlank
    @Column(name = "numero_processo")
    private String numero_processo;
}
