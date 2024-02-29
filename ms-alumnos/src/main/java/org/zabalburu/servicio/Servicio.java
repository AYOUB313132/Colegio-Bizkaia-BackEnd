package org.zabalburu.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zabalburu.modelo.Alumno;
import org.zabalburu.repository.AlumnoRepo;

@Service
public class Servicio {
	
	@Autowired
	private AlumnoRepo repo;
	
	public List<Alumno> getAlumnos(){
		return repo.findAll(Sort.by("nombre"));
	}
	
	public Alumno getAlumno(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public Alumno añadirAlumno (Alumno nuevo) {
		return repo.save(nuevo);
	}
	
	public Boolean eliminarAlumno(Integer id) {
		Alumno borrar = getAlumno(id);
		if(borrar != null) {
			repo.delete(borrar);
			return true;
		}
		return false;
	}
	
	
	public Alumno modificarAlumno(Alumno modificar) {
		return repo.save(modificar);
	}
	
	
}
