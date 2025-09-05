package com.academico.sga.dto;

public class ReporteEstudiantesPorCicloDTO {

    private final String ciclo;
    private final Long totalEstudiantes;

    public ReporteEstudiantesPorCicloDTO(String ciclo, Long totalEstudiantes) {
        this.ciclo = ciclo;
        this.totalEstudiantes = totalEstudiantes;
    }

    public String getCiclo() {
        return ciclo;
    }

    public Long getTotalEstudiantes() {
        return totalEstudiantes;
    }
}
