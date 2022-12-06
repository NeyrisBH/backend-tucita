package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tucita.medicalteam.model.Usuario;
import com.tucita.medicalteam.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository repositorio;
	
	@Override
	public List<Usuario> consultar() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Usuario> consultarUsuario(String usuario) {
		if (usuario == null) {
			return Optional.empty();
		}
		return repositorio.findById(usuario);
	}

	@Override
	public Usuario crear(Usuario usuario) {
		if (usuario == null) {
			return null;
		}
		return repositorio.insert(usuario);
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		if (usuario == null) {
			return null;
		}
		return repositorio.save(usuario);
	}

	@Override
	public String eliminar(String usuario) {
		if (usuario != null) {
			repositorio.deleteById(usuario);
			return "OK";
		}
		return null;
	}

}
