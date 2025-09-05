package com.academico.sga.dto;

public class ReporteCursosPorProfesorDTO {
    private final String nombreProfesor;
    private final Long cantidadCursos;

    public ReporteCursosPorProfesorDTO(String nombreProfesor, Long cantidadCursos) {
        this.nombreProfesor = nombreProfesor;
        this.cantidadCursos = cantidadCursos;
    }

    public String getNombreProfesor() { return nombreProfesor; }
    public Long getCantidadCursos() { return cantidadCursos; }
}
