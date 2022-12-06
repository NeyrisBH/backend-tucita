package com.tucita.medicalteam.model;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usuarios")
public class Usuario {

	@Id
	private String usuario;
	private String clave;
	private Long idUsuario;
	private String rol;

	public Usuario() {
		super();
	}

	public Usuario(String usuario, String clave, Long idUsuario, String rol) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.idUsuario = idUsuario;
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clave, idUsuario, rol, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(clave, other.clave) && Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(rol, other.rol) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", clave=" + clave + ", idUsuario=" + idUsuario + ", rol=" + rol + "]";
	}
}
