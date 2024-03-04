package org.zabalburu.alumnos.controlador;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zabalburu.alumnos.modelo.Alumno;
import org.zabalburu.alumnos.modelo.AlumnoDTO;
import org.zabalburu.alumnos.servicio.ServicioAlumnos;

@RestController
@RequestMapping("alumnos")
public class AlumnosControlador {
	
	@Autowired
	private ServicioAlumnos servicio;
	
	@GetMapping("")
	public AlumnoDTO getalumnos(@RequestParam (defaultValue = "1") Integer p){
		return servicio.getAlumnosDto(p);
	}
	/*
	@GetMapping("")
    public List<Alumno> getAlumnos() {
        return servicio.getAlumnos();
    }
	*/
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable Integer id){
		Alumno a = servicio.getAlumno(id);
		if(a != null) {
			return ResponseEntity.ok(a);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("")
	public ResponseEntity<Alumno> añadirAlumno(@RequestBody Alumno nuevo) throws URISyntaxException{
		if(!nuevo.getApellido().isBlank() && !nuevo.getNombre().isBlank() &&
				!nuevo.getEmail().isBlank() && !nuevo.getContraseña().isBlank()
				&& nuevo.getFechaNacimiento() != null ) {
			servicio.añadirAlumno(nuevo);
			return ResponseEntity.created(new URI("alumnos/" + nuevo.getAlumnoId())).body(nuevo);
		}
		return ResponseEntity.unprocessableEntity().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Alumno> eliminarAlumno(@PathVariable Integer id){
		if(servicio.eliminarAlumno(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Alumno> modificarAlumno(@PathVariable Integer id, @RequestBody Alumno modificar){
		Alumno a = servicio.getAlumno(id);
		if(a != null) {
			modificar.setAlumnoId(id);
			
			if(!modificar.getNombre().isBlank() && !modificar.getApellido().isBlank()
					&& !modificar.getEmail().isBlank() && !modificar.getContraseña().isBlank()
					&& !modificar.getCiudad().isBlank() && modificar.getCodigoPostal() != null
					&& !modificar.getDireccion().isBlank() && modificar.getFechaNacimiento() != null
					&& !modificar.getGenero().isBlank() && modificar.getMovil() != null
					&& !modificar.getProvincia().isBlank() && !modificar.getPais().isBlank()) {
				servicio.modificarAlumno(modificar);
				return ResponseEntity.ok(modificar);
			}
			
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.notFound().build();
	}
}
