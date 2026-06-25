package com.satc.controller;

import com.satc.dto.professor.ProfessorRequestDto;
import com.satc.dto.professor.ProfessorResponseDto;
import com.satc.service.ProfessorService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/  professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> buscarProfessores() {
        List<ProfessorResponseDto> professores = professorService.buscarProfessores();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> buscarProfessor(@PathVariable Long id) {
        ProfessorResponseDto professor = professorService.buscarProfessor(id);
        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> salvaProfessor(@RequestBody @Valid ProfessorRequestDto dto) {
        ProfessorResponseDto salvo = professorService.salvaProfessor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> editaProfessor(@PathVariable Long id, @RequestBody @Valid ProfessorRequestDto dto) {
        ProfessorResponseDto editado = professorService.editaProfessor(id, dto);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaProfessor(@PathVariable Long id) {
        professorService.deletaProfessor(id);
        return ResponseEntity.noContent().build();
    }
}