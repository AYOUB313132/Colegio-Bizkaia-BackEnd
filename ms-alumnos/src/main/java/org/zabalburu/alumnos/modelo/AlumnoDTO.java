package org.zabalburu.alumnos.modelo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {
	
	private int numPagina;
	private int totalPaginas;
	private List<Alumno> alumnos;
	
}
