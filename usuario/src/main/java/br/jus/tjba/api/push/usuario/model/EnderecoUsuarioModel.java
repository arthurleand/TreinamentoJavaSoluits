package br.jus.tjba.api.push.usuario.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "endereco_usuario)")
@Table(name = "endereco_usuario")
public class EnderecoUsuarioModel {

    @Id
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UsuarioModel usuario;
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;
    private String cep;
}
