package com.tucita.medicalteam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tucita.medicalteam.model.Usuario;
import com.tucita.medicalteam.repository.AutenticacionRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AutenticacionRepository repositorio;
	
	@Override
	public boolean loginUsuario(String usuario, String clave) {
		Optional<Usuario> usaurioConsulta = repositorio.loginUsuario(usuario, clave);
		return usaurioConsulta.isPresent();
	}

}
