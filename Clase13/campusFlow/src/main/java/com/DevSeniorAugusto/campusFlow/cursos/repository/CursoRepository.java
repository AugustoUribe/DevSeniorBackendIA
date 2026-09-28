package com.DevSeniorAugusto.campusFlow.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevSeniorAugusto.campusFlow.cursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
}

