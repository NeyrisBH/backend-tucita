package com.tucita.medicalteam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tucita.medicalteam.model.Paciente;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, Long>{
	
	@Query("{nombrePaciente:'?0'}")
    List<Paciente> findByNombre(String nombrePaciente);

}
