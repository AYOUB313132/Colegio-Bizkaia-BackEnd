package org.zabalburu.alumnos.modelo;

import java.util.Date;
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
@Table(name = "alumnos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Alumno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "alumno_id")
    private Integer alumnoId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "password")
    private String contraseña;
    
    @Column(name = "role_id")
    private Integer roleId;
    
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
    
    private String imagen;
    

}
