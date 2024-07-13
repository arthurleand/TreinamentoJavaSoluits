package br.jus.tjba.api.push.usuario.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioProcessoSistemaID implements Serializable {

    private Long id_usuario;
    private Long id_sistema;

}
