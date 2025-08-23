package com.academico.sga.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.academico.sga.dto.ProfesorDTO;
import com.academico.sga.exception.ResourceNotFoundException;
import com.academico.sga.model.Profesor;
import com.academico.sga.repository.ProfesorRepository;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    private ProfesorDTO toDTO(Profesor p) {
        return new ProfesorDTO(p.getId(), p.getNombre(), p.getApellido(), p.getEspecialidad(), null);
    }

    public List<ProfesorDTO> obtenerTodos(String especialidad) {
        List<Profesor> base;
        if (especialidad != null) {
            base = profesorRepository.findByEspecialidadIgnoreCase(especialidad);
        } else {
            base = profesorRepository.findAll();
        }
        return base.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProfesorDTO obtenerPorId(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con id " + id));
        return toDTO(profesor);
    }
}
