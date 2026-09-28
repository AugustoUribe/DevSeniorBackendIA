package com.DevSeniorAugusto.campusFlow.cursos.mapper;


import com.DevSeniorAugusto.campusFlow.cursos.dto.CursoResponse;
import com.DevSeniorAugusto.campusFlow.cursos.model.Curso;

public class CursoMapper {

    public static CursoResponse toResponse(Curso curso) {
        CursoResponse response = new CursoResponse();
        response.setId(curso.getId());
        response.setNombre(curso.getNombre());
        response.setInstructorNombre(
                curso.getInstructor() != null ? curso.getInstructor().getNombre() : null);
        response.setCantidadEstudiantes(curso.getEstudiantes().size());
        return response;
    }
}