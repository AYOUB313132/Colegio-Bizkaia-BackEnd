package org.zabalburu.modelo;

import java.util.Date;
import lombok.Data;

@Data
public class Profesor {

	private Integer profesorId;
	private String nombre;
	private String apellido;
	private String contraseña;
	private String genero;
	private Date fechaNacimiento;
	private String direccion;
	private Integer movil;
	private String email;
	private String ciudad;
	private Integer codigoPostal;
	private String provincia;
	private String pais;
	private Integer role;
	private String imagen;
}
