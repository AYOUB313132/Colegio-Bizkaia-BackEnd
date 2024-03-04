package org.zabalburu.alumnos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zabalburu.alumnos.modelo.Alumno;

public interface AlumnosRepo extends JpaRepository<Alumno, Integer> {

}
