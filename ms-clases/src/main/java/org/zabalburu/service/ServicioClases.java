package org.zabalburu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.zabalburu.exception.AlumnoNotFound;
import org.zabalburu.exception.CursoNotFound;
import org.zabalburu.exception.ProfesorNotFound;
import org.zabalburu.modelo.Clase;
import org.zabalburu.modelo.InscripcionClase;
import org.zabalburu.repo.ClasesRepo;
import org.zabalburu.repo.InscripcionesRepo;


@Service
public class ServicioClases {

private final String URL_PROFESORES  = "http://localhost:servicio-profesores/profesores";
private final String URL_CURSOS  = "http://localhost:servicio-cursos/cursos";
private final String URL_ALUMNOS  = "http://localhost:servicio-alumnos/alumnos";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ClasesRepo clasesRepo;
	
	@Autowired
	private InscripcionesRepo inscripcionesRepo;
	
	
	public List<Clase> getClases() {
        return clasesRepo.findAll();
    }
	
	public Clase getClase(Integer id) {
		return clasesRepo.findById(id).orElse(null);
	}
	
	public Clase añadirClase(Clase nuevo) throws ProfesorNotFound, CursoNotFound {
		try {
			 restTemplate.getForObject(URL_PROFESORES + "/{id}", Object.class, nuevo.getProfesorId());
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new ProfesorNotFound("El profesor con el id: " + nuevo.getProfesorId() + " No Existe!");
		}
		
		try {
			 restTemplate.getForObject(URL_CURSOS + "/{id}", Object.class, nuevo.getCursoId());
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new CursoNotFound("El Curso con el id: " + nuevo.getCursoId() + " No Existe!");
		}
		
		return clasesRepo.save(nuevo);
	}
	
	public boolean eliminarClase(Integer id) {
		Clase c = getClase(id);
		if(c != null) {
			clasesRepo.delete(c);
			return true;
		}
		return false;
	}
	
	public Clase modificarClase(Clase modificar) throws ProfesorNotFound, CursoNotFound {
		try {
			 restTemplate.getForObject(URL_PROFESORES + "/{id}", Object.class, modificar.getProfesorId());
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new ProfesorNotFound("El profesor con el id: " + modificar.getProfesorId() + " No Existe!");
		}
		
		try {
			 restTemplate.getForObject(URL_CURSOS + "/{id}", Object.class, modificar.getCursoId());
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new CursoNotFound("El Curso con el id: " + modificar.getCursoId() + " No Existe!");
		}
		return clasesRepo.save(modificar);
	}
	
	
	/* ========== inscripciones ========== */ 
	
	
	public List<InscripcionClase> getInscripcionClases() {
        return inscripcionesRepo.findAll();
    }
	
	public InscripcionClase getInscripcionClase(Integer id) {
		return inscripcionesRepo.findById(id).orElse(null);
	}
	/* SELECT * FROM alumnos a
	JOIN inscripciones_clases ic ON a.alumno_id = ic.alumno_id
			WHERE ic.clase_id = 1; */
	public List<?> getAlumnosByIdClase(Integer idClase){
		Clase c = getClase(idClase);
		if (c != null) {
			return inscripcionesRepo.findByClase(c);
		}
		return null;
	}
	
	
	public InscripcionClase registrarAlumno(InscripcionClase nueva) throws AlumnoNotFound {
		
		try {
			 restTemplate.getForObject(URL_ALUMNOS + "/{id}", Object.class, nueva.getAlumnoId());
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new AlumnoNotFound("El alumno con el id: " + nueva.getAlumnoId() + " No Existe!");
		}
		
		return inscripcionesRepo.save(nueva);
	}
	
}
