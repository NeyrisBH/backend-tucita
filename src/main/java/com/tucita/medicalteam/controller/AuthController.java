package com.tucita.medicalteam.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tucita.medicalteam.model.Usuario;
import com.tucita.medicalteam.service.AuthService;
import com.tucita.medicalteam.service.UsuarioService;
import com.tucita.medicalteam.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.UnsupportedJwtException;


@RestController
@RequestMapping("/api/token")
public class AuthController {
	
	@Autowired
	private AuthService servicio;
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	
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
	
	@GetMapping("refresh")
	public ResponseEntity<?> actualizarToken(HttpServletRequest request){
		String token2 = null;
		try {
			
			String headers = request.getHeader(HEADER);
			if (headers == null) {
				SecurityContextHolder.clearContext();
			} else if (headers.startsWith(PREFIX)) {
				String token = headers.replace(PREFIX, "");
				Claims contenido = Jwts.parser().setSigningKey(JwtUtil.KEYWORD.getBytes())
						.parseClaimsJws(token).getBody();
				String usuario = (String) contenido.get("usuario");
				System.out.println(usuario);
				List<String> rolesString = (List<String>) contenido.get("authorities");
				token2 = JwtUtil.crearToken(usuario, rolesString.get(0));
				System.out.println(token2);
				
			} else {
				SecurityContextHolder.clearContext();
			}
		} catch (ExpiredJwtException | UnsupportedJwtException e) {
		}
		return ResponseEntity.ok(new JSONObject().put("token", token2).toString());
	}
}
