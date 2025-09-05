package com.academico.sga.repository;

import com.academico.sga.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Reporte 3: Cantidad de estudiantes por ciclo académico
    @Query("SELECT new com.academico.sga.dto.ReporteEstudiantesPorCicloDTO(i.cicloAcademico, COUNT(i.estudiante)) " +
           "FROM Inscripcion i GROUP BY i.cicloAcademico")
    List<ReporteEstudiantesPorCicloDTO> contarEstudiantesPorCiclo();
}
