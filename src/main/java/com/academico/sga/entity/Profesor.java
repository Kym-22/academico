package com.academico.sga.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String especialidad;

    @Column(name = "anios_experiencia", nullable = false)
    private Integer aniosExperiencia;

    public Profesor() {}

    public Profesor(String nombre, String apellido, String especialidad, Integer aniosExperiencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public Integer getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(Integer aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }
}
