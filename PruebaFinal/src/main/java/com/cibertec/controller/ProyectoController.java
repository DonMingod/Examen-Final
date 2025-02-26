package com.cibertec.controller;


import com.cibertec.model.Paciente;
import com.cibertec.repository.PacienteRepository;
import com.cibertec.servicio.PacienteServicio;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/Paciente")
public class ProyectoController {
	  @Autowired
	    private PacienteServicio pacienteServicio;
	    
	  @PostMapping("/add")
	  public ResponseEntity<String> addPaciente(@RequestBody Paciente paciente) {
	      try {
	          Paciente pacienteSaveToDB = pacienteServicio.registrarPaciente(paciente);
	          String pathPDF = pacienteServicio.generarConstanciaPDF(pacienteSaveToDB);
	          return new ResponseEntity<>("Paciente registrado y constancia generada en: " + pathPDF, HttpStatus.CREATED);
	      } catch (Exception e) {
	          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }

	    @GetMapping("/listar")
	    public String listarPacientes(Model model) {
	        List<Paciente> pacientes = pacienteServicio.listarPacientes();
	        model.addAttribute("pacientes", pacientes);
	        return "listar";
	    }
	  
	  @GetMapping("/registrar")
	    public String mostrarFormularioRegistro(Model model) {
	        model.addAttribute("paciente", new Paciente());
	        return "registrar"; 
	    }
	   
	   
	
}
