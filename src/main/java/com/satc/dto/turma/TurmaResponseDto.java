package com.satc.dto.turma;

import com.satc.dto.professor.ProfessorResponseDto;
import com.satc.dto.sala.SalaResponseDto;

import java.util.List;


public record TurmaResponseDto(

        Long id,
        String nome,
        String serie,
        String turno,

        // Objeto completo do professor — reutiliza o DTO já criado
        ProfessorResponseDto professor,

        // Objeto completo da sala
        SalaResponseDto sala,

        // Lista resumida de alunos (apenas id e nome) para evitar referência circular
        List<AlunoResumo> alunos
) {
    public record AlunoResumo(Long id, String nome, String matricula) {}
}