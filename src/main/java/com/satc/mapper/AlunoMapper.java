package com.satc.mapper;


import com.satc.dto.aluno.AlunoRequestDto;
import com.satc.dto.aluno.AlunoResponseDto;
import com.satc.entity.Aluno;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    // Converte o DTO recebido na API para a Entidade do banco
    Aluno paraEntidade(AlunoRequestDto dto);
    List<Aluno> paraListaEntidades(List<AlunoRequestDto> dtos);

    // Converte a Entidade do banco para o DTO de retorno da API
    AlunoResponseDto paraResposta(Aluno aluno);
    List<AlunoResponseDto> paraListaResposta(List<Aluno> alunos);
}
