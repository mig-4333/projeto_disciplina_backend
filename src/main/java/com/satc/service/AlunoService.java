package com.satc.service;

import com.satc.dto.aluno.AlunoRequestDto;
import com.satc.dto.aluno.AlunoResponseDto;
import com.satc.entity.Aluno;
import com.satc.mapper.AlunoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.satc.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private AlunoMapper alunoMapper;

    public List<AlunoResponseDto> buscarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        List<AlunoResponseDto> alunosDto = alunoMapper.paraListaResposta(alunos);
        return alunosDto;
    }

    public AlunoResponseDto buscarAluno(Long id) {
        Optional<Aluno> optional_aluno = alunoRepository.findById(id);
        Aluno aluno = optional_aluno.orElseThrow( () -> new RuntimeException("Valor não encontrado"));
        AlunoResponseDto alunoDto = alunoMapper.paraResposta(aluno);
        return alunoDto;
    }

    public AlunoResponseDto salvaAluno(AlunoRequestDto alunoReqDto) {
        Aluno alunoEntidade = alunoMapper.paraEntidade(alunoReqDto);
        Aluno aluno = alunoRepository.save(alunoEntidade);
        AlunoResponseDto resposta = alunoMapper.paraResposta(aluno);
        return resposta;
    }

    public AlunoResponseDto editaAluno(Long id, AlunoRequestDto alunoReqDto) {
        Aluno alunoEntidade = alunoMapper.paraEntidade(alunoReqDto);
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        Aluno aluno = optionalAluno.orElseThrow( () -> new RuntimeException("Valor não encontrado"));

        aluno.setNome(alunoEntidade.getNome());
        aluno.setIdade(alunoEntidade.getIdade());
        aluno.setMatricula(alunoEntidade.getMatricula());
        aluno.setEmail(alunoEntidade.getEmail());
        Aluno alunoSalvo = alunoRepository.save(aluno);

        AlunoResponseDto alunoResDto = alunoMapper.paraResposta(alunoSalvo);
        return alunoResDto;
    }

    public void deletaAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Valor não encontrado"));
        alunoRepository.delete(aluno);
    }
}

