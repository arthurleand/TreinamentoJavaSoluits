package br.jus.tjba.api.push.usuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Usuario")
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    private String cpf;


    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<UsuarioProcessoSistemaModel> usuarioProcessoSistemaModelList;
}
