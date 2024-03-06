package org.zabalburu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zabalburu.modelo.Alumno;
import org.zabalburu.modelo.Clase;

@Repository
public interface ClasesRepo extends JpaRepository<Clase, Integer> {
	 List<?> findByClaseId(Integer claseId);
}
