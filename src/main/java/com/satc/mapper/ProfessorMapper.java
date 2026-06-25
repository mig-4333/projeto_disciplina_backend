package com.satc.mapper;

import com.satc.dto.professor.ProfessorRequestDto;
import com.satc.dto.professor.ProfessorResponseDto;
import com.satc.entity.Professor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProfessorMapper {


    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    Professor paraEntidade(ProfessorRequestDto dto);

    ProfessorResponseDto paraResposta(Professor professor);

    List<ProfessorResponseDto> paraListaResposta(List<Professor> professores);
}