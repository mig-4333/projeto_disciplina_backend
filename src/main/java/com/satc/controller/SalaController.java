package com.satc.controller;

import com.satc.dto.sala.SalaRequestDto;
import com.satc.dto.sala.SalaResponseDto;
import com.satc.service.SalaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public ResponseEntity<List<SalaResponseDto>> buscarSalas() {
        return ResponseEntity.ok(salaService.buscarSalas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDto> buscarSala(@PathVariable Long id) {
        return ResponseEntity.ok(salaService.buscarSala(id));
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<SalaResponseDto> buscarPorNumero(@PathVariable String numero) {
        return ResponseEntity.ok(salaService.buscarPorNumero(numero));
    }

    @PostMapping
    public ResponseEntity<SalaResponseDto> salvaSala(@RequestBody @Valid SalaRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.salvaSala(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaResponseDto> editaSala(
            @PathVariable Long id,
            @RequestBody @Valid SalaRequestDto dto) {
        return ResponseEntity.ok(salaService.editaSala(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaSala(@PathVariable Long id) {
        salaService.deletaSala(id);
        return ResponseEntity.noContent().build();
    }
}