package com.academico.sga.repository;

import com.academico.sga.dto.ReporteCursosPorProfesorDTO;
import com.academico.sga.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    List<Profesor> findByEspecialidadIgnoreCase(String especialidad);

    List<Profesor> findByAniosExperienciaGreaterThanEqual(Integer min);


    @Query("SELECT new com.academico.sga.dto.ReporteCursosPorProfesorDTO(p.nombre, COUNT(c)) " +
           "FROM Profesor p LEFT JOIN p.cursos c GROUP BY p.nombre")
    List<ReporteCursosPorProfesorDTO> contarCursosPorProfesor();
}
