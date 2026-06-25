package com.satc.mapper;

import com.satc.dto.turma.TurmaRequestDto;
import com.satc.dto.turma.TurmaResponseDto;
import com.satc.entity.Turma;
import com.satc.entity.Aluno;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProfessorMapper.class, SalaMapper.class})
public interface TurmaMapper {

    TurmaMapper INSTANCE = Mappers.getMapper(TurmaMapper.class);

    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "sala", ignore = true)
    @Mapping(target = "alunos", ignore = true)
    @Mapping(target = "id", ignore = true)
    Turma paraEntidade(TurmaRequestDto dto);

    @Mapping(target = "alunos", source = "alunos", qualifiedByName = "converterAlunosParaResumo")
    TurmaResponseDto paraResposta(Turma turma);

    List<TurmaResponseDto> paraListaResposta(List<Turma> turmas);

    @Named("converterAlunosParaResumo")
    default List<TurmaResponseDto.AlunoResumo> converterAlunosParaResumo(List<Aluno> alunos) {
        if (alunos == null) return List.of();
        return alunos.stream()
                .map(a -> new TurmaResponseDto.AlunoResumo(a.getId(), a.getNome(), a.getMatricula()))
                .toList();
    }
}