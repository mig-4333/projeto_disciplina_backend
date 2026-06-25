package com.satc.dto.turma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record TurmaRequestDto(

        @NotBlank(message = "O nome da turma é obrigatório")
        @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
        String nome,

        @NotBlank(message = "A série é obrigatória")
        @Size(max = 30, message = "A série deve ter no máximo 30 caracteres")
        String serie,

        @NotBlank(message = "O turno é obrigatório")
        @Size(max = 20, message = "O turno deve ter no máximo 20 caracteres")
        String turno,

        Long professorId,

        Long salaId
) {}