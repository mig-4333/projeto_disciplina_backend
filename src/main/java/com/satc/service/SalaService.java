package com.satc.service;

import com.satc.dto.sala.SalaRequestDto;
import com.satc.dto.sala.SalaResponseDto;
import com.satc.entity.Sala;
import com.satc.mapper.SalaMapper;
import com.satc.repository.SalaRepository;
import com.satc.repository.TurmaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private SalaMapper salaMapper;

    public List<SalaResponseDto> buscarSalas() {
        return salaMapper.paraListaResposta(salaRepository.findAll());
    }

    public SalaResponseDto buscarSala(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com id: " + id));
        return salaMapper.paraResposta(sala);
    }

    public SalaResponseDto buscarPorNumero(String numero) {
        Sala sala = salaRepository.findByNumero(numero)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com número: " + numero));
        return salaMapper.paraResposta(sala);
    }

    public SalaResponseDto salvaSala(SalaRequestDto dto) {
        if (salaRepository.existsByNumero(dto.numero())) {
            throw new RuntimeException("Já existe uma sala com o número: " + dto.numero());
        }

        Sala entidade = salaMapper.paraEntidade(dto);
        Sala salva = salaRepository.save(entidade);
        return salaMapper.paraResposta(salva);
    }

    public SalaResponseDto editaSala(Long id, SalaRequestDto dto) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com id: " + id));

        if (!sala.getNumero().equals(dto.numero()) && salaRepository.existsByNumero(dto.numero())) {
            throw new RuntimeException("Já existe uma sala com o número: " + dto.numero());
        }
        sala.setNumero(dto.numero());
        sala.setCapacidade(dto.capacidade());
        return salaMapper.paraResposta(salaRepository.save(sala));
    }

    public void deletaSala(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com id: " + id));

        if (turmaRepository.existsBySalaId(id)) {
            throw new RuntimeException("Não é possível excluir a sala pois ela está vinculada a uma turma.");
        }
        salaRepository.delete(sala);
    }
}