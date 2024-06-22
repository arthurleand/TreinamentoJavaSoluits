package br.jus.tjba.api.push.usuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_usuario")
@Entity(name = "UsuarioProcessoSistema)")
@Table(name = "usuario_processo_sistema")
public class UsuarioProcessoSistemaModel {

    @NotBlank
    @Id
    private Long id_usuario;

    @NotBlank
    private Long id_sistema;

    @NotBlank
    private String numeroProcesso;
}
