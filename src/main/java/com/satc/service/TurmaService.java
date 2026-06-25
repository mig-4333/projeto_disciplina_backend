package com.satc.service;

import com.satc.dto.turma.TurmaRequestDto;
import com.satc.dto.turma.TurmaResponseDto;
import com.satc.entity.Professor;
import com.satc.entity.Sala;
import com.satc.entity.Turma;
import com.satc.mapper.TurmaMapper;
import com.satc.repository.ProfessorRepository;
import com.satc.repository.SalaRepository;
import com.satc.repository.TurmaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private TurmaMapper turmaMapper;

    // ── Listar todas ──────────────────────────────────────────────────────────

    public List<TurmaResponseDto> buscarTurmas() {
        return turmaMapper.paraListaResposta(turmaRepository.findAll());
    }

    // ── Buscar por ID ─────────────────────────────────────────────────────────

    public TurmaResponseDto buscarTurma(Long id) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com id: " + id));
        return turmaMapper.paraResposta(turma);
    }

    // ── Buscar por professor ──────────────────────────────────────────────────

    public List<TurmaResponseDto> buscarPorProfessor(Long professorId) {
        return turmaMapper.paraListaResposta(turmaRepository.findByProfessorId(professorId));
    }

    // ── Buscar por turno ──────────────────────────────────────────────────────

    public List<TurmaResponseDto> buscarPorTurno(String turno) {
        return turmaMapper.paraListaResposta(turmaRepository.findByTurno(turno));
    }

    // ── Criar ─────────────────────────────────────────────────────────────────

    public TurmaResponseDto salvaTurma(TurmaRequestDto dto) {
        Turma turma = turmaMapper.paraEntidade(dto);

        // Vincula professor se informado no DTO
        if (dto.professorId() != null) {
            Professor professor = professorRepository.findById(dto.professorId())
                    .orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + dto.professorId()));
            turma.setProfessor(professor);
        }

        // Vincula sala se informada no DTO
        if (dto.salaId() != null) {
            Sala sala = salaRepository.findById(dto.salaId())
                    .orElseThrow(() -> new RuntimeException("Sala não encontrada com id: " + dto.salaId()));
            turma.setSala(sala);
        }

        return turmaMapper.paraResposta(turmaRepository.save(turma));
    }

    // ── Editar ────────────────────────────────────────────────────────────────

    public TurmaResponseDto editaTurma(Long id, TurmaRequestDto dto) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com id: " + id));

        turma.setNome(dto.nome());
        turma.setSerie(dto.serie());
        turma.setTurno(dto.turno());

        // Atualiza professor (permite desvincular passando null)
        if (dto.professorId() != null) {
            Professor professor = professorRepository.findById(dto.professorId())
                    .orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + dto.professorId()));
            turma.setProfessor(professor);
        } else {
            turma.setProfessor(null);
        }

        // Atualiza sala (permite desvincular passando null)
        if (dto.salaId() != null) {
            Sala sala = salaRepository.findById(dto.salaId())
                    .orElseThrow(() -> new RuntimeException("Sala não encontrada com id: " + dto.salaId()));
            turma.setSala(sala);
        } else {
            turma.setSala(null);
        }

        return turmaMapper.paraResposta(turmaRepository.save(turma));
    }

    // ── Deletar ───────────────────────────────────────────────────────────────

    public void deletaTurma(Long id) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com id: " + id));
        turmaRepository.delete(turma);
    }
}