package com.satc.entity;

import jakarta.persistence.*;


@Entity
public class Sala {

    // ── Chave primária ────────────────────────────────────────────────────────
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ── Atributos ─────────────────────────────────────────────────────────────

    /**
     * Identificação da sala (ex: "101", "LAB-02").
     * Único para não existir duas salas com o mesmo número.
     */
    @Column(nullable = false, unique = true, length = 20)
    private String numero;

    /**
     * Número máximo de alunos que a sala comporta.
     * Usado para verificar disponibilidade ao associar a uma turma.
     */
    @Column(nullable = false)
    private Integer capacidade;

    // ── Getters e Setters ─────────────────────────────────────────────────────

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
}
