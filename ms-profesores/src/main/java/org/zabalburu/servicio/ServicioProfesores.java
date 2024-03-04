package org.zabalburu.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zabalburu.modelo.Profesor;
import org.zabalburu.modelo.ProfesorDTO;
import org.zabalburu.repo.ProfesoresRepo;


@Service
public class ServicioProfesores {
	
	@Autowired
	private ProfesoresRepo repo;
	public ProfesorDTO getProfesoresDTO(Integer numPagina){
		PageRequest pg = PageRequest.of(numPagina, 3);
		Page<Profesor> page = repo.findAll(pg);
		return new ProfesorDTO(numPagina + 1, page.getTotalPages(), page.getContent());
	}
	
	public List<Profesor> getProfesores() {
        return repo.findAll(Sort.by("nombre"));
    }
	
	public Profesor getProfesor(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public Profesor añadirProfesor(Profesor nuevo) {
		return repo.save(nuevo);
	}
	
	public boolean eliminarProfesor(Integer id) {
		Profesor p = getProfesor(id);
		if(p != null) {
			repo.delete(p);
			return true;
		}
		return false;
	}
	
	public Profesor modificarProfesor(Profesor modificar) {
		return repo.save(modificar);
	}
}







