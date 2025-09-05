package com.academico.sga.repository;

import com.academico.sga.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByFechaNacimientoBefore(LocalDate end);

    List<Estudiante> findByFechaNacimientoAfter(LocalDate start);

    List<Estudiante> findByApellidoContainingIgnoreCase(String apellido);

    List<Estudiante> findByFechaNacimientoBetween(LocalDate start, LocalDate end);
}
