package org.zabalburu.modelo;

import java.util.Date;

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
@Table(name = "profesores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Profesor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "profesor_id")
    private Integer profesorId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "password")
    private String contraseña;
    
    private String genero;
    
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    private String direccion;

    private Integer movil;
    
    private String email;
    
    private String ciudad;
    
    @Column(name = "codigo_postal")
    private Integer codigoPostal;
    
    private String provincia;
    
    private String pais;
    
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;
}
