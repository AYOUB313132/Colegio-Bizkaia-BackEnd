package org.zabalburu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zabalburu.modelo.Profesor;

@Repository
public interface ProfesoresRepo extends JpaRepository<Profesor, Integer>{
	
}
