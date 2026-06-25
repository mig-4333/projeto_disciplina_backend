package com.satc.dto.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoRequestDto(
    @NotBlank(message = "O nome é obrigatório")
    String nome,

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    String email,

    @NotNull(message = "A idade é obrigatória")
    @Digits(integer=2, fraction=0)
    Long idade,

    @NotBlank(message = "A matrícula é obrigatória")
    @Size(min=7, max=7, message = "A matrícula deve ter 7 caracteres")
    String matricula
) {}

