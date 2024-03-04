package org.zabalburu.alumnos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zabalburu.alumnos.modelo.Alumno;
import org.zabalburu.alumnos.modelo.AlumnoDTO;
import org.zabalburu.alumnos.repo.AlumnosRepo;


@Service
public class ServicioAlumnos {
	
	@Autowired
	private AlumnosRepo repo;
	
	public AlumnoDTO getAlumnosDto(Integer numPagina){
		PageRequest pg = PageRequest.of(numPagina, 5);
		Page<Alumno> page = repo.findAll(pg);
		return new AlumnoDTO(numPagina , page.getTotalPages(), page.getContent());
	}
	
	public List<Alumno> getAlumnos() {
        return repo.findAll(Sort.by("nombre"));
    }
	
	public Alumno getAlumno(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public Alumno añadirAlumno(Alumno nuevo) {
		return repo.save(nuevo);
	}
	
	public boolean eliminarAlumno(Integer id) {
		Alumno a = getAlumno(id);
		if(a != null) {
			repo.delete(a);
			return true;
		}
		return false;
	}
	
	
	public Alumno modificarAlumno(Alumno modificar) {
		return repo.save(modificar);
	}
}

