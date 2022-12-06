package com.tucita.medicalteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tucita.medicalteam.model.Usuario;

@Service
public interface UsuarioService {
	public List<Usuario> consultar();
	public Optional<Usuario> consultarUsuario(String usuario);
	public Usuario crear(Usuario usuario);
	public Usuario actualizar(Usuario usuario);
	public String eliminar(String usuario);
}
