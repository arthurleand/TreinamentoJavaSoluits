package br.jus.tjba.api.push.usuario.model.form;

import jakarta.validation.constraints.NotNull;

public record EnderecoForm(
                 @NotNull
                 String rua,
                 @NotNull
                 String bairro,
                 String numero,
                 @NotNull
                 String cidade,
                 @NotNull
                 String uf,
                 @NotNull
                 String cep
) {
}
