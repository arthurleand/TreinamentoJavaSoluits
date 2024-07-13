package br.jus.tjba.api.push.usuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "EnderecoUsuario)")
@Table(name = "endereco_usuario")
public class EnderecoUsuarioModel {

    @Id
    private Long id;

    @NotBlank
    private String rua;

    @NotBlank
    private String bairro;
    private String numero;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    @NotBlank
    private String cep;
}
