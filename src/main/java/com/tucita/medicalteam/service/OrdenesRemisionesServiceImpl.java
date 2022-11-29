package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucita.medicalteam.model.OrdenesRemisiones;
import com.tucita.medicalteam.repository.OrdenesRemisionesRepository;


@Service
public class OrdenesRemisionesServiceImpl implements OrdenesRemisionesService  {
	
	@Autowired
	private OrdenesRemisionesRepository repositorio;
	
	@Override
	public OrdenesRemisiones actualizarOrden(OrdenesRemisiones ordenesRemisiones) {
		Optional<OrdenesRemisiones> ordenAActualizar = repositorio.findById(ordenesRemisiones.getId());
		if(ordenAActualizar.isPresent()) {
			return repositorio.save(ordenesRemisiones);
		}
		return null;
	}

	@Override
	public OrdenesRemisiones crearOrden(OrdenesRemisiones ordenesRemisiones) {
		Optional<OrdenesRemisiones> ordenACrear = repositorio.findById(ordenesRemisiones.getId());
		if(ordenACrear.isPresent()) {
			return null;
		}
		return repositorio.insert(ordenesRemisiones);
	}

	@Override
	public String eliminarOrden(Long id) {
		Optional<OrdenesRemisiones> ordenAEliminar = repositorio.findById(id);
		if(ordenAEliminar.isPresent()) {
			repositorio.delete(ordenAEliminar.get());
			return "La orden ha sido eliminada con exito!";
		}
		return "La orden no ha podido ser eliminada, ID no encontrado";
	}

	@Override
	public Optional<OrdenesRemisiones> consultarOrden(Long id, String tipoExamen) {
		if (id == null && tipoExamen == null) {
			return Optional.empty();
		}
		if (id == null) {
			List<OrdenesRemisiones> lista = repositorio.findByTipoExamen(tipoExamen);
			return Optional.of(lista.get(0));
		}
		return repositorio.findById(id);
	}


	@Override
	public List<OrdenesRemisiones> consultarLista() {
		return repositorio.findAll();
	}

	@Override
	public Optional<OrdenesRemisiones> consultarOrdenPorMedico(Long idMedicoGeneral) {
		if (idMedicoGeneral == null) {
			return Optional.empty();
		}
		return repositorio.findByMedico(idMedicoGeneral);
	}

}
