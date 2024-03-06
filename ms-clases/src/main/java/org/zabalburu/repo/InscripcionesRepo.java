package org.zabalburu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zabalburu.modelo.Alumno;
import org.zabalburu.modelo.Clase;
import org.zabalburu.modelo.InscripcionClase;

@Repository
public interface InscripcionesRepo extends JpaRepository<InscripcionClase, Integer> {
	 List<?> findByClase(Clase clase); 
	
}
