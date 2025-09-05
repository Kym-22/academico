package com.academico.sga.dto;

public class ReportePromedioCursoDTO {
    private final String nombreCurso;
    private final Double notaPromedio;

    public ReportePromedioCursoDTO(String nombreCurso, Double notaPromedio) {
        this.nombreCurso = nombreCurso;
        this.notaPromedio = notaPromedio;
    }

    public String getNombreCurso() { return nombreCurso; }
    public Double getNotaPromedio() { return notaPromedio; }
}
