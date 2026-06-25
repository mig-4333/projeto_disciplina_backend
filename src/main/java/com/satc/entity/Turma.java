package com.satc.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turma {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(nullable = false, length = 50) private String nome;

    @Column(nullable = false, length = 30) private String serie;

    @Column(nullable = false, length = 20) private String turno;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = true)
    private Professor professor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id", nullable = true)
    private Sala sala;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }


    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        aluno.setTurma(this);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
        aluno.setTurma(null);
    }
}