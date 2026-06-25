package com.satc.dto.sala;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SalaRequestDto(

        @NotBlank(message = "O número da sala é obrigatório")
        @Size(max = 20, message = "O número deve ter no máximo 20 caracteres")
        String numero,

        @NotNull(message = "A capacidade é obrigatória")
        @Min(value = 1, message = "A capacidade deve ser pelo menos 1")
        Integer capacidade
) {}