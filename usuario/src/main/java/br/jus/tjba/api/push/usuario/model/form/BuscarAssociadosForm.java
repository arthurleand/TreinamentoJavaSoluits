package br.jus.tjba.api.push.usuario.model.form;

import jakarta.validation.constraints.NotNull;

public record BuscarAssociadosForm(
            @NotNull
            Long id_sistema,

            @NotNull
            String numero_processo) {
}
