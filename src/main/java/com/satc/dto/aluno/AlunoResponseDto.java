package com.satc.dto.aluno;

public record AlunoResponseDto(

        Long id,
        String nome,
        String email,
        Long idade,
        String matricula
) {}
