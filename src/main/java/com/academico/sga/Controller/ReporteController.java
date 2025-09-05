package com.academico.sga.Controller;

import com.academico.sga.dto.ReporteCursosPorProfesorDTO;
import com.academico.sga.dto.ReportePromedioCursoDTO;
import com.academico.sga.dto.ReporteTopCursosDTO;
import com.academico.sga.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/cursos-por-profesor")
    public List<ReporteCursosPorProfesorDTO> cursosPorProfesor() {
        return reporteService.getCursosPorProfesor();
    }

    @GetMapping("/promedio-notas-por-curso")
    public List<ReportePromedioCursoDTO> promedioNotasPorCurso() {
        return reporteService.getPromedioNotasPorCurso();
    }

    @GetMapping("/estudiantes-por-ciclo")
    public List<Object> estudiantesPorCiclo() {
        return reporteService.getEstudiantesPorCiclo();
    }

    @GetMapping("/top3-cursos")
    public List<ReporteTopCursosDTO> top3Cursos() {
        return reporteService.getTop3Cursos();
    }
}
