package org.zabalburu.controlador;

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
import org.zabalburu.modelo.Profesor;
import org.zabalburu.modelo.ProfesorDTO;
import org.zabalburu.servicio.ServicioProfesores;

@RestController
@RequestMapping("profesores")
public class ProfesorControlador {

	@Autowired
	private ServicioProfesores servicio;
	
	@GetMapping("")
	public ProfesorDTO getProfesorDTO(@RequestParam (defaultValue = "1") Integer p){
		return servicio.getProfesoresDTO(p-1);
	}
	
	/*
	@GetMapping("")
    public List<Profesor> getProfesores() {
        return servicio.getProfesores();
    }*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Profesor> getProfesor(@PathVariable Integer id){
		Profesor p = servicio.getProfesor(id);
		if(p != null) {
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("")
	public ResponseEntity<Profesor> añadirProfesor(@RequestBody Profesor nuevo) throws URISyntaxException{
		if(!nuevo.getApellido().isBlank() && !nuevo.getNombre().isBlank() && nuevo.getRole() != null
				&& !nuevo.getEmail().isBlank() && !nuevo.getContraseña().isBlank()
				&& nuevo.getFechaNacimiento() != null) {
			servicio.añadirProfesor(nuevo);
			return ResponseEntity.created(new URI("profesores/" + nuevo.getProfesorId())).body(nuevo);
		}
		return ResponseEntity.unprocessableEntity().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Integer id){
		if(servicio.eliminarProfesor(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Profesor> modificarAlumno(@PathVariable Integer id, @RequestBody Profesor modificar){
		Profesor p = servicio.getProfesor(id);
		if(p != null) {
			modificar.setProfesorId(id);
			
			if(!modificar.getNombre().isBlank() && !modificar.getApellido().isBlank()
					&& !modificar.getEmail().isBlank() && !modificar.getContraseña().isBlank()
					&& !modificar.getCiudad().isBlank() && modificar.getCodigoPostal() != null
					&& !modificar.getDireccion().isBlank() && modificar.getFechaNacimiento() != null
					&& !modificar.getGenero().isBlank() && modificar.getMovil() != null && modificar.getRole() != null
					&& !modificar.getProvincia().isBlank() && !modificar.getPais().isBlank()) {
				servicio.modificarProfesor(modificar);
				return ResponseEntity.ok(modificar);
			}
			
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
	
	
	
}
