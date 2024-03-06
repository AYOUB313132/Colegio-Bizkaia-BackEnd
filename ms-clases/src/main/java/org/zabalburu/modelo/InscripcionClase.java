package org.zabalburu.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "inscripciones_clases")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InscripcionClase {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "inscripcion_id")
    private Integer inscripcionId;

    @Column(name = "alumno_id")
    private Integer alumnoId;
    
    @ManyToOne()
    @JoinColumn(name = "clase_id")
    private Clase clase;
    
    
}
