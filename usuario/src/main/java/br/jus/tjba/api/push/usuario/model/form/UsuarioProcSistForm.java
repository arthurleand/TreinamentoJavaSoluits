package br.jus.tjba.api.push.usuario.model.form;


import jakarta.validation.constraints.NotBlank;

public record UsuarioProcSistForm(
        @NotBlank
        Long id_usuario,

        @NotBlank
        Long id_sistema,

        @NotBlank
        String numero_processo
) {
}
