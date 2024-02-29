package org.zabalburu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zabalburu.modelo.Alumno;

@Repository
public interface AlumnoRepo extends JpaRepository<Alumno, Integer>{

}
