package org.zabalburu.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "horario")
    private String fechaInicio;
    
    @Column(name = "fecha_final")
    private String fechaFinal;
    
    @Column(name = "tipo_id")
    private String tipoId;
    
    
}
