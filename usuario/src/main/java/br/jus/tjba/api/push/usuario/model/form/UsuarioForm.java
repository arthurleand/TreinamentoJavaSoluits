package br.jus.tjba.api.push.usuario.model.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UsuarioForm(
                @NotBlank
                @Email
                String login,

                @NotBlank
                String senha,

                @NotBlank
                @Pattern(regexp = "(^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$)", message = "CPF INVALIDO")
                String cpf,

                @NotNull
                EnderecoForm enderecoForm
) {
}
