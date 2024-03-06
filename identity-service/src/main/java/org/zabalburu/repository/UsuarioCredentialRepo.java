package org.zabalburu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zabalburu.modelo.UsuarioCredential;

@Repository
public interface UsuarioCredentialRepo extends JpaRepository<UsuarioCredential, Integer> {

}
