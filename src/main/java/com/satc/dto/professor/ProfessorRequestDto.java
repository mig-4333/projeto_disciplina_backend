package com.satc.dto.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorRequestDto(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A disciplina é obrigatória")
        @Size(max = 100, message = "A disciplina deve ter no máximo 100 caracteres")
        String disciplina,

        // E-mail é opcional (nullable na entidade), mas se informado deve ser válido
        @Email(message = "E-mail inválido")
        String email
) {}