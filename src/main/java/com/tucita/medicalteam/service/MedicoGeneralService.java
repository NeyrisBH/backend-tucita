package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import com.tucita.medicalteam.model.MedicoGeneral;

public interface MedicoGeneralService {
	
	public MedicoGeneral actualizarMedicoGeneral(MedicoGeneral medicoGeneral);
	public MedicoGeneral crearMedico(MedicoGeneral medicoGeneral);
	public String eliminarMedicoGeneral(Long id);
	public Optional<MedicoGeneral> consultarMedicoGeneral(Long id,String nombreMedico);
	public List<MedicoGeneral> consultarLista();
	public Optional<MedicoGeneral> consultarMedicoPorArea(String areaMedico);
}
