package com.tucita.medicalteam.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tucita.medicalteam.model.MedicoGeneral;
import com.tucita.medicalteam.service.MedicoGeneralService;

@RestController
@RequestMapping("/api/medico")
public class MedicoGeneralController {
	
	@Autowired
	private MedicoGeneralService servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarLista());
	}
	
	@GetMapping("/d/{id}")
	public ResponseEntity<?> ConsultarPorID(@PathVariable Long id){
		Optional<MedicoGeneral> medico = servicio.consultarMedicoGeneral(id, null);
		if(medico.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(medico.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
	}
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody MedicoGeneral medicoGeneral){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearMedico(medicoGeneral));
	}
	@PutMapping("/d/{id}")
	public ResponseEntity<?> actualizarMedico(@RequestBody MedicoGeneral medicoGeneral,@PathVariable Long id){
		Optional<MedicoGeneral> medicoConsultado = servicio.consultarMedicoGeneral(id, null);
		if(medicoConsultado.isPresent()) {
			if(medicoGeneral.getId().equals(id)) {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarMedicoGeneral(medicoGeneral));
			} else {
				JSONObject mensajeError1 = new JSONObject();
				mensajeError1.put("Mensaje", "El ID no corresponde");
			}
		} else {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("mensaje", "El medico consultado no se encuentra en la base de datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
		return null;
	
	}
	@DeleteMapping("/d/{id}")
	public ResponseEntity<?> eliminarMedicoPorId(@PathVariable Long id){
		servicio.eliminarMedicoGeneral(id);
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarLista());
	}
	
	@GetMapping("/a/{areaMedico}")
	public ResponseEntity<?> consultarPorArea(@PathVariable String areaMedico) {
		Optional<MedicoGeneral> medico = servicio.consultarMedicoPorArea(areaMedico);
		if (medico.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(medico.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
