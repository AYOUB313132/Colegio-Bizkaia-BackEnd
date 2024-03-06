package org.zabalburu.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zabalburu.exception.AlumnoNotFound;
import org.zabalburu.exception.CursoNotFound;
import org.zabalburu.exception.ProfesorNotFound;
import org.zabalburu.modelo.Clase;
import org.zabalburu.modelo.InscripcionClase;
import org.zabalburu.service.ServicioClases;


@RestController
@RequestMapping("clases")
public class ClasesControlador {
	
	@Autowired
	private ServicioClases servicio;
	
	@GetMapping("")
    public List<Clase> getProfesores() {
        return servicio.getClases();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Clase> getClase(@PathVariable Integer id){
		Clase c = servicio.getClase(id);
		if(c != null) {
			return ResponseEntity.ok(c);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping("")
	public ResponseEntity<Clase> añadirClase(@RequestBody Clase nuevo) throws URISyntaxException, ProfesorNotFound, CursoNotFound{
		if(nuevo.getCursoId() != null && nuevo.getProfesorId() != null 
				&& !nuevo.getHorario().isBlank() && nuevo.getAula() != null ) {
			
					servicio.añadirClase(nuevo);
					return ResponseEntity.created(new URI("clases/" + nuevo.getProfesorId())).body(nuevo);
		}
		return ResponseEntity.unprocessableEntity().build();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Clase> eliminarClase(@PathVariable Integer id){
		if(servicio.eliminarClase(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Clase> modificarClase(@PathVariable Integer id, @RequestBody Clase modificar) throws ProfesorNotFound, CursoNotFound{
		Clase c = servicio.getClase(id);
		if(c != null) {
			modificar.setClaseId(id);
			
			if(modificar.getCursoId() != null && modificar.getProfesorId() != null 
				&& !modificar.getHorario().isBlank() && modificar.getAula() != null ) {
							servicio.modificarClase(modificar);
							return ResponseEntity.ok(modificar);
			}
			
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	/* ========== inscripciones ========== */ 
	
	
	@GetMapping("/inscripciones")
    public List<InscripcionClase> getInscripcionClases() {
        return servicio.getInscripcionClases();
    }
	
	@GetMapping("/inscripciones/{id}")
	public ResponseEntity<InscripcionClase> getInscripcionClase(@PathVariable Integer id){
		InscripcionClase ic = servicio.getInscripcionClase(id);
		if(ic != null) {
			return ResponseEntity.ok(ic);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/alumnosMatriculado/{id}")
	public ResponseEntity<?> getAlumnosMatriculadoByIdClase(@PathVariable Integer id){
		List<?> alumnos = servicio.getAlumnosByIdClase(id);
		if(alumnos != null) {
			return ResponseEntity.ok(alumnos);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping("/registrar")
	public ResponseEntity<InscripcionClase> registrarAlumno(@RequestBody InscripcionClase nueva) throws AlumnoNotFound{
		Clase clase = servicio.getClase(nueva.getClase().getClaseId());
		if(clase != null && nueva.getAlumnoId() != null) {
			servicio.registrarAlumno(nueva);
			return ResponseEntity.ok(nueva);
		}
		return ResponseEntity.notFound().build();
		
		/*
		if(nueva.getAlumnoId() != null && nueva.getClase() != null) {
			servicio.registrarAlumno(nueva);
			return ResponseEntity.ok(nueva);
		}
		return ResponseEntity.notFound().build();
		*/
	}
}
