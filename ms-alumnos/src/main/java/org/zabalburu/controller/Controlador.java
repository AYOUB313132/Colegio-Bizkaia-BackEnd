package org.zabalburu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zabalburu.modelo.Alumno;
import org.zabalburu.service.ServicioAlumnos;

@RestController
@RequestMapping("alumnos")
public class Controlador {
	
	@Autowired
	private ServicioAlumnos servicio;
	
	public List<Alumno> getAlumnos(){
		return servicio.getAlumnos();
	}
}
