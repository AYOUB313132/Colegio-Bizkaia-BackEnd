package org.zabalburu.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zabalburu.modelo.UsuarioCredential;
import org.zabalburu.repository.UsuarioCredentialRepo;

@Service
public class AuthService {
	
	private final String URL_PROFESORES  = "http://localhost:servicio-profesores/profesores";
	private final String URL_ALUMNOS  = "http://localhost:servicio-alumnos/alumnos";

	@Autowired
	private RestTemplate restTemplate;
		
	@Autowired
	private UsuarioCredentialRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public UsuarioCredential añadirUsuario(UsuarioCredential nuevo) {
		nuevo.setContraseña(passwordEncoder.encode(nuevo.getContraseña()));
		return repo.save(nuevo);
	}
	
	
	
	
}
