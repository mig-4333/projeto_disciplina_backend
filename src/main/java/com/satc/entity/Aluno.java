package com.satc.entity;

import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(nullable = false, length = 100) private String nome;

    @Column(nullable = false) private Long idade;

    @Column(nullable = false, unique = true, length = 20) private String matricula;

    @Column(nullable = true) private String email;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "turma_id", nullable = true) private Turma turma;

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdade() {
        return idade;
    }
    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
}