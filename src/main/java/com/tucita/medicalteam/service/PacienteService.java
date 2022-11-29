package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import com.tucita.medicalteam.model.Paciente;

public interface PacienteService {
	
	public Paciente actualizarPaciente(Paciente paciente);
	public Paciente crearPaciente(Paciente paciente);
	public String eliminarPaciente(Long id);
	public Optional<Paciente> consultarPaciente(Long id,String nombrePaciente);
	public List<Paciente> consultarLista();

}
