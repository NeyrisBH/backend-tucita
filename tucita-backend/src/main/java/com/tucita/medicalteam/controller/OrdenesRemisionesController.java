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

import com.tucita.medicalteam.model.OrdenesRemisiones;
import com.tucita.medicalteam.service.OrdenesRemisionesService;


@RestController
@RequestMapping("/api/ordenes")
public class OrdenesRemisionesController {
	
	@Autowired
	private OrdenesRemisionesService servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarLista());
	}
	
	@GetMapping("/d/{id}")
	public ResponseEntity<?> ConsultarPorID(@PathVariable Long id){
		Optional<OrdenesRemisiones> orden = servicio.consultarOrden(id, null);
		if(orden.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(orden.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
	}
	@PostMapping
	public ResponseEntity<?> crearOrden(@RequestBody OrdenesRemisiones ordenesRemisiones){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearOrden(ordenesRemisiones));
	}
	@PutMapping("/d/{id}")
	public ResponseEntity<?> actualizarOrden(@RequestBody OrdenesRemisiones ordenesRemisiones,@PathVariable Long id){
		Optional<OrdenesRemisiones> ordenConsultada = servicio.consultarOrden(id, null);
		if(ordenConsultada.isPresent()) {
			if(ordenesRemisiones.getId().equals(id)) {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarOrden(ordenesRemisiones));
			} else {
				JSONObject mensajeError1 = new JSONObject();
				mensajeError1.put("Mensaje", "El ID no corresponde");
			}
		} else {
			JSONObject mensajeError = new JSONObject();
			mensajeError.put("mensaje", "La orden consultada no se encuentra en la base de datos");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
		}
		return null;
	
	}
	@DeleteMapping("/d/{id}")
	public ResponseEntity<?> eliminarOrdenPorId(@PathVariable Long id){
		servicio.eliminarOrden(id);
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarLista());
	}
	
	@GetMapping("/m/{idMedicoGeneral}")
	public ResponseEntity<?> consultarPorMedico(@PathVariable Long idMedicoGeneral){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarOrdenPorMedico(idMedicoGeneral));
	}
}

