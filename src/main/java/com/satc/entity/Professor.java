package com.satc.entity;

import jakarta.persistence.*;

@Entity
public class Professor {

    // ── Chave primária gerada automaticamente pelo banco ──────────────────────
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ── Atributos básicos ─────────────────────────────────────────────────────

    /** Nome completo do professor. Não pode ser nulo. */
    @Column(nullable = false, length = 100)
    private String nome;

    /**
     * Disciplina lecionada pelo professor (ex: "Matemática", "Português").
     * Não pode ser nulo.
     */
    @Column(nullable = false, length = 100)
    private String disciplina;

    /** E-mail de contato. Opcional, mas único quando informado. */
    @Column(nullable = true)
    private String email;

    // ── Getters e Setters ─────────────────────────────────────────────────────
    // Necessários para o MapStruct e para o JPA funcionarem corretamente.

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}