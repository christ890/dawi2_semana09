package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService service;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> listaAlumno(){
		log.info(">>> Lista <<<<");
		List<Alumno> lstAlumno = service.listaAlumno();
		return ResponseEntity.ok(lstAlumno);
	}
	
	@PostMapping
	public ResponseEntity<Alumno> registra(@RequestBody Alumno alumno){
		log.info(">>> Registra <<<<" + alumno.getDni());
		Alumno registrado = service.insertaActualizaAlumno(alumno);
		if(registrado != null) {
			return ResponseEntity.ok(registrado);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
