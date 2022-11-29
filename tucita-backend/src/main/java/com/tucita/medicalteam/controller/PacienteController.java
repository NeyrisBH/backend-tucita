package com.tucita.medicalteam.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tucita.medicalteam.model.Paciente;
import com.tucita.medicalteam.service.PacienteService;
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarLista());
	}
	
	@GetMapping("/d/{id}")
	public ResponseEntity<?> ConsultarPorID(@PathVariable Long id){
		Optional<Paciente> paciente = servicio.consultarPaciente(id, null);
		if(paciente.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(paciente.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
	}
	@PostMapping
	public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearPaciente(paciente));
	}
	@PutMapping("/d/{id}")
	public ResponseEntity<?> actualizarPaciente(@RequestBody Paciente paciente,@PathVariable Long id){
		Optional<Paciente> pacienteConsultado = servicio.consultarPaciente(id, null);
		if(pacienteConsultado.isPresent()) {
			if(paciente.getId().equals(id)) {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarPaciente(paciente));
			} else {
				JSONObject mensajeError1 = new JSONObject();
				mensajeError1.put("Mensaje", "El ID no corresponde");
			}
		} else {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("mensaje", "El paciente consultado no se encuentra en la base de datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
		return null;
	
	}
	@DeleteMapping("/d/{id}")
	public ResponseEntity<?> eliminarPacientePorId(@PathVariable Long id){
		Optional<Paciente> paciente = servicio.consultarPaciente(id, null);
		if (paciente.isPresent()) {
			servicio.eliminarPaciente(id);
			return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarLista());
		} else {

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Registro no encontrado}");
	}


	}

