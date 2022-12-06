package com.tucita.medicalteam.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tucita.medicalteam.model.Usuario;
import com.tucita.medicalteam.service.AuthService;
import com.tucita.medicalteam.service.UsuarioService;
import com.tucita.medicalteam.util.JwtUtil;

@RestController
@RequestMapping("/api/token")
public class AuthController {
	
	@Autowired
	private AuthService servicio;
	
	@Autowired
	private UsuarioService servicioUsuario;
	
	@PostMapping()
	public ResponseEntity<?> consultarToken(@RequestBody Usuario usuario){
		boolean respuesta = servicio.loginUsuario(usuario.getUsuario(), usuario.getClave());
		if (!respuesta) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		Optional<Usuario> usuarioConsulta = servicioUsuario.consultarUsuario(usuario.getUsuario());
		String token = JwtUtil.crearToken(usuario.getUsuario(), usuarioConsulta.get().getRol());
		System.out.println(token);
		return ResponseEntity.ok(new JSONObject().put("token", token).toString());
	}
}
