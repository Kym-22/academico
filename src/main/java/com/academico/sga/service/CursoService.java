package com.academico.sga.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.academico.sga.dto.CursoDTO;
import com.academico.sga.exception.ResourceNotFoundException;
import com.academico.sga.model.Curso;
import com.academico.sga.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    private CursoDTO toDTO(Curso c) {
        return new CursoDTO(c.getId(), c.getNombre(), c.getSemestre(), c.getProfesor().getNombre());
    }

    public List<CursoDTO> obtenerTodos(Integer semestre) {
        List<Curso> base;
        if (semestre != null) {
            base = cursoRepository.findBySemestre(semestre);
        } else {
            base = cursoRepository.findAll();
        }
        return base.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CursoDTO obtenerPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con id " + id));
        return toDTO(curso);
    }
}
