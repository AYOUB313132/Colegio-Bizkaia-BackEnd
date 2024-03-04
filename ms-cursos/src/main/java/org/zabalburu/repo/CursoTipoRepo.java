package org.zabalburu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zabalburu.modelo.TipoCurso;

public interface CursoTipoRepo extends JpaRepository<TipoCurso, Integer> {

}
