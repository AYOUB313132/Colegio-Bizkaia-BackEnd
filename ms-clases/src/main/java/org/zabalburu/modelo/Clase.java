package org.zabalburu.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "clases")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Clase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "clase_id")
    private Integer claseId;

    @Column(name = "curso_id")
    private Integer cursoId;

    @Column(name = "profesor_id")
    private String profesorId;
    
    private String horario;
    
    private Integer aula;
    
    @OneToMany(mappedBy = "clase")
    @JsonIgnore
    private List<InscripcionClase> inscripciones;
    
    
}
