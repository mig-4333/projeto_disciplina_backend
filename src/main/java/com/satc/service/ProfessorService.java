package com.satc.service;

import com.satc.dto.professor.ProfessorRequestDto;
import com.satc.dto.professor.ProfessorResponseDto;
import com.satc.entity.Professor;
import com.satc.mapper.ProfessorMapper;
import com.satc.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private ProfessorMapper professorMapper;

    public List<ProfessorResponseDto> buscarProfessores() {
        List<Professor> professores = professorRepository.findAll();
        return professorMapper.paraListaResposta(professores);
    }

    public ProfessorResponseDto buscarProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + id));
        return professorMapper.paraResposta(professor);
    }

    public ProfessorResponseDto salvaProfessor(ProfessorRequestDto dto) {
        Professor entidade = professorMapper.paraEntidade(dto);
        Professor salvo = professorRepository.save(entidade);
        return professorMapper.paraResposta(salvo);
    }

    public ProfessorResponseDto editaProfessor(Long id, ProfessorRequestDto dto) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + id));

        professor.setNome(dto.nome());
        professor.setDisciplina(dto.disciplina());
        professor.setEmail(dto.email());

        Professor salvo = professorRepository.save(professor);
        return professorMapper.paraResposta(salvo);
    }

    public void deletaProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + id));
        professorRepository.delete(professor);
    }
}