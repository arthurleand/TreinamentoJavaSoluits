package br.jus.tjba.api.push.usuario.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO{
    private Long id;
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;
    private String cep;
}
