package com.cibertec.controller;
import com.cibertec.model.Atencion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cibertec.servicio.AtencionServicio;

public class AtencionController {
	 @Autowired
	    private AtencionServicio atencionServicio;

	    @PostMapping("/registrar")
	    public ResponseEntity<Atencion> registrarAtencion(@RequestBody Atencion atencion) {
	        Atencion nuevaAtencion = atencionServicio.registrarAtencion(atencion);
	        return new ResponseEntity<>(nuevaAtencion, HttpStatus.CREATED);
	    }

	    @GetMapping("/listar")
	    public ResponseEntity<List<Atencion>> listarAtenciones() {
	        List<Atencion> atenciones = atencionServicio.listarAtenciones();
	        return ResponseEntity.ok(atenciones);
	    }
}
