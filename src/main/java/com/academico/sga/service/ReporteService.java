package com.academico.sga.service;

import com.academico.sga.dto.*;
import com.academico.sga.repository.CursoRepository;
import com.academico.sga.repository.InscripcionRepository;
import com.academico.sga.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ProfesorRepository profesorRepo;

    @Autowired
    private CursoRepository cursoRepo;

    @Autowired
    private InscripcionRepository inscripcionRepo;

    // Reporte 1
    public List<ReporteCursosPorProfesorDTO> getCursosPorProfesor() {
        return profesorRepo.contarCursosPorProfesor();
    }

    // Reporte 2
    public List<ReportePromedioCursoDTO> getPromedioNotasPorCurso() {
        return cursoRepo.promedioNotasPorCurso();
    }

    // Reporte 3
    public List<ReporteEstudiantesPorCicloDTO> getEstudiantesPorCiclo() {
        return inscripcionRepo.contarEstudiantesPorCiclo();
    }

    // Reporte 4
    public List<ReporteTopCursosDTO> getTop3Cursos() {
        return cursoRepo.top3Cursos(PageRequest.of(0,3));
    }
}
