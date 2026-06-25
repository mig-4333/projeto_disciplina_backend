package com.satc.controller;

import com.satc.dto.turma.TurmaRequestDto;
import com.satc.dto.turma.TurmaResponseDto;
import com.satc.service.TurmaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaResponseDto>> buscarTurmas() {
        return ResponseEntity.ok(turmaService.buscarTurmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponseDto> buscarTurma(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.buscarTurma(id));
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<TurmaResponseDto>> buscarPorProfessor(@PathVariable Long professorId) {
        return ResponseEntity.ok(turmaService.buscarPorProfessor(professorId));
    }

    @GetMapping("/turno/{turno}")
    public ResponseEntity<List<TurmaResponseDto>> buscarPorTurno(@PathVariable String turno) {
        return ResponseEntity.ok(turmaService.buscarPorTurno(turno));
    }

    @PostMapping
    public ResponseEntity<TurmaResponseDto> salvaTurma(@RequestBody @Valid TurmaRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.salvaTurma(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponseDto> editaTurma(
            @PathVariable Long id,
            @RequestBody @Valid TurmaRequestDto dto) {
        return ResponseEntity.ok(turmaService.editaTurma(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaTurma(@PathVariable Long id) {
        turmaService.deletaTurma(id);
        return ResponseEntity.noContent().build();
    }
}