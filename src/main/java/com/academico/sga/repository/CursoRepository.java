package com.academico.sga.repository;

import com.academico.sga.dto.ReportePromedioCursoDTO;
import com.academico.sga.dto.ReporteTopCursosDTO;
import com.academico.sga.entity.Curso;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findBySemestre(Integer semestre);

    List<Curso> findByNombreContainingIgnoreCase(String nombre);

    List<Curso> findByProfesor_NombreContainingIgnoreCase(String profesorNombre);

    @Query("SELECT new com.academico.sga.dto.ReportePromedioCursoDTO(c.nombre, AVG(i.nota)) " +
           "FROM Curso c JOIN c.inscripciones i GROUP BY c.nombre")
    List<ReportePromedioCursoDTO> promedioNotasPorCurso();

    @Query("SELECT new com.academico.sga.dto.ReporteTopCursosDTO(c.nombre, AVG(i.nota)) " +
           "FROM Curso c JOIN c.inscripciones i GROUP BY c.nombre ORDER BY AVG(i.nota) DESC")
    List<ReporteTopCursosDTO> top3Cursos(Pageable pageable);
}
