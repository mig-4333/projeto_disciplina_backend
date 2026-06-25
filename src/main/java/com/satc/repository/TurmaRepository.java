package com.satc.repository;

import com.satc.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

    /**
     * Usa @Query com JPQL porque o nome do método ficaria muito extenso.
     * "t.professor.id" navega pelo relacionamento @ManyToOne sem precisar de JOIN explícito.
     */
    @Query("SELECT t FROM Turma t WHERE t.professor.id = :professorId")
    List<Turma> findByProfessorId(@Param("professorId") Long professorId);

    boolean existsBySalaId(Long salaId);

    List<Turma> findByTurno(String turno);
}