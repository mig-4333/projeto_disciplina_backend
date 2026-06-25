package com.satc.controller;

import com.satc.dto.aluno.AlunoRequestDto;
import com.satc.dto.aluno.AlunoResponseDto;
import com.satc.service.AlunoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

        @Autowired
        private AlunoService alunoService;

        @GetMapping
        public List<AlunoResponseDto> listarAlunos() {
            return alunoService.buscarAlunos();
        };

        @GetMapping("/{id}")
        public ResponseEntity<AlunoResponseDto> listaAlunoId(@PathVariable Long id) {
            AlunoResponseDto aluno = alunoService.buscarAluno(id);
            ResponseEntity<AlunoResponseDto> resposta = ResponseEntity.ok(aluno);
            return resposta;
        };

        @PostMapping
        public ResponseEntity<AlunoResponseDto> criaAluno (@RequestBody @Valid AlunoRequestDto aluno) {
            AlunoResponseDto novoAluno = alunoService.salvaAluno(aluno);
            ResponseEntity<AlunoResponseDto> resposta_http = ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
            return resposta_http;
        }

        @PutMapping("/{id}")
        public ResponseEntity<AlunoResponseDto> editaAluno(@PathVariable Long id, @RequestBody @Valid AlunoRequestDto aluno){
            AlunoResponseDto alunoEditado = alunoService.editaAluno(id, aluno);
            ResponseEntity<AlunoResponseDto> resposta_http = ResponseEntity.ok(alunoEditado);
            return resposta_http;
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletaAluno(@PathVariable Long id) {
            alunoService.deletaAluno(id);
            return ResponseEntity.noContent().build();
        }
}
