package com.satc.mapper;

import com.satc.dto.sala.SalaRequestDto;
import com.satc.dto.sala.SalaResponseDto;
import com.satc.entity.Sala;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    SalaMapper INSTANCE = Mappers.getMapper(SalaMapper.class);

    Sala paraEntidade(SalaRequestDto dto);

    SalaResponseDto paraResposta(Sala sala);

    List<SalaResponseDto> paraListaResposta(List<Sala> salas);
}