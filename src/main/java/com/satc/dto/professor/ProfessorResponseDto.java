package com.satc.dto.professor;


public record ProfessorResponseDto(

        Long id,
        String nome,
        String disciplina,
        String email
) {}