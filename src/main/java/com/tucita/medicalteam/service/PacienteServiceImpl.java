package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucita.medicalteam.model.Paciente;
import com.tucita.medicalteam.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository repositorio;
	
	@Override
	public Paciente actualizarPaciente(Paciente paciente) {
		Optional<Paciente> pacienteAActualizar = repositorio.findById(paciente.getId());
		if(pacienteAActualizar.isPresent()) {
			return repositorio.save(paciente);
		}
		return null;
	}

	@Override
	public Paciente crearPaciente(Paciente paciente) {
		Optional<Paciente> pacienteACrear = repositorio.findById(paciente.getId());
		if(pacienteACrear.isPresent()) {
			return null;
		}
		/*List<Paciente> pacientes = repositorio.findByNombre(paciente.getNombrePaciente());
		if(pacientes.size() > 0) {
			return pacientes.get(0);
		}*/
		return repositorio.insert(paciente);
	}
	

	@Override
	public String eliminarPaciente(Long id) {
		Optional<Paciente> pacienteAEliminar = repositorio.findById(id);
		if(pacienteAEliminar.isPresent()) {
			repositorio.deleteById(pacienteAEliminar.get().getId());
		}
		return null;
	}

	@Override
	public Optional<Paciente> consultarPaciente(Long id, String nombrePaciente) {
		if (id == null && nombrePaciente == null) {
			return Optional.empty();
		}
		if (id == null) {
			List<Paciente> lista = repositorio.findByNombre(nombrePaciente);
			return Optional.of(lista.get(0));
		}
		return repositorio.findById(id);
	}


	@Override
	public List<Paciente> consultarLista() {
		return repositorio.findAll();
	}

}
