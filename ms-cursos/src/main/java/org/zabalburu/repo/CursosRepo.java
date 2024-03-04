package org.zabalburu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zabalburu.modelo.Curso;

public interface CursosRepo extends JpaRepository<Curso, Integer> {

}
