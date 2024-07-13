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

    @NotBlank
    @Id
    @ManyToOne
    private UsuarioModel id_usuario;

    @NotBlank
    @Id
    @ManyToOne
    private SistemaModel id_sistema;

    @NotBlank
    private String numeroProcesso;
}
