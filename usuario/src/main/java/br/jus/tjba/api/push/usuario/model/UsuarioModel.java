package br.jus.tjba.api.push.usuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank
    @Email
    private String login;

    @NotBlank
    private String senha;

    @NotBlank
    @Pattern(regexp = "(^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$)")
    private String cpf;

    @OneToOne(cascade = CascadeType.REMOVE)
    @MapsId
    private EnderecoUsuarioModel enderecoUsuarioModel;

    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.REMOVE)
    private List<UsuarioProcessoSistemaModel> usuarioProcessoSistemaModelList;
}
