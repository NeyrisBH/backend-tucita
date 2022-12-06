package com.tucita.medicalteam.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("patient")
public class Paciente {
	
	@Id
	private Long id;
	private String nombrePaciente;
	private String apellidoPaternoPaciente;
	private String apellidoMaternoPaciente;
	private Long telefonoPaciente;
	private String emailPaciente;
	private String fechaNacimientoPaciente;
	private String generoPaciente;
	private String ciudadResidenciaPaciente;
	private String direccionResidenciaPaciente;
	private Long codigoAfiliacionPaciente;
	
	
	
	public Paciente() {
		super();
	}

	public Paciente(Long id, String nombrePaciente, String apellidoPaternoPaciente, String apellidoMaternoPaciente,
			Long telefonoPaciente, String emailPaciente, String fechaNacimientoPaciente, String generoPaciente,
			String ciudadResidenciaPaciente, String direccionResidenciaPaciente, Long codigoAfiliacionPaciente) {
		super();
		this.id = id;
		this.nombrePaciente = nombrePaciente;
		this.apellidoPaternoPaciente = apellidoPaternoPaciente;
		this.apellidoMaternoPaciente = apellidoMaternoPaciente;
		this.telefonoPaciente = telefonoPaciente;
		this.emailPaciente = emailPaciente;
		this.fechaNacimientoPaciente = fechaNacimientoPaciente;
		this.generoPaciente = generoPaciente;
		this.ciudadResidenciaPaciente = ciudadResidenciaPaciente;
		this.direccionResidenciaPaciente = direccionResidenciaPaciente;
		this.codigoAfiliacionPaciente = codigoAfiliacionPaciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidoPaternoPaciente() {
		return apellidoPaternoPaciente;
	}

	public void setApellidoPaternoPaciente(String apellidoPaternoPaciente) {
		this.apellidoPaternoPaciente = apellidoPaternoPaciente;
	}

	public String getApellidoMaternoPaciente() {
		return apellidoMaternoPaciente;
	}

	public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
		this.apellidoMaternoPaciente = apellidoMaternoPaciente;
	}

	public Long getTelefonoPaciente() {
		return telefonoPaciente;
	}

	public void setTelefonoPaciente(Long telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getFechaNacimientoPaciente() {
		return fechaNacimientoPaciente;
	}

	public void setFechaNacimientoPaciente(String fechaNacimientoPaciente) {
		this.fechaNacimientoPaciente = fechaNacimientoPaciente;
	}

	public String getGeneroPaciente() {
		return generoPaciente;
	}

	public void setGeneroPaciente(String generoPaciente) {
		this.generoPaciente = generoPaciente;
	}

	public String getCiudadResidenciaPaciente() {
		return ciudadResidenciaPaciente;
	}

	public void setCiudadResidenciaPaciente(String ciudadResidenciaPaciente) {
		this.ciudadResidenciaPaciente = ciudadResidenciaPaciente;
	}

	public String getDireccionResidenciaPaciente() {
		return direccionResidenciaPaciente;
	}

	public void setDireccionResidenciaPaciente(String direccionResidenciaPaciente) {
		this.direccionResidenciaPaciente = direccionResidenciaPaciente;
	}

	public Long getCodigoAfiliacionPaciente() {
		return codigoAfiliacionPaciente;
	}

	public void setCodigoAfiliacionPaciente(Long codigoAfiliacionPaciente) {
		this.codigoAfiliacionPaciente = codigoAfiliacionPaciente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaternoPaciente, apellidoPaternoPaciente, ciudadResidenciaPaciente,
				codigoAfiliacionPaciente, direccionResidenciaPaciente, emailPaciente, fechaNacimientoPaciente,
				generoPaciente, id, nombrePaciente, telefonoPaciente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(apellidoMaternoPaciente, other.apellidoMaternoPaciente)
				&& Objects.equals(apellidoPaternoPaciente, other.apellidoPaternoPaciente)
				&& Objects.equals(ciudadResidenciaPaciente, other.ciudadResidenciaPaciente)
				&& Objects.equals(codigoAfiliacionPaciente, other.codigoAfiliacionPaciente)
				&& Objects.equals(direccionResidenciaPaciente, other.direccionResidenciaPaciente)
				&& Objects.equals(emailPaciente, other.emailPaciente)
				&& Objects.equals(fechaNacimientoPaciente, other.fechaNacimientoPaciente)
				&& Objects.equals(generoPaciente, other.generoPaciente) && Objects.equals(id, other.id)
				&& Objects.equals(nombrePaciente, other.nombrePaciente)
				&& Objects.equals(telefonoPaciente, other.telefonoPaciente);
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombrePaciente=" + nombrePaciente + ", apellidoPaternoPaciente="
				+ apellidoPaternoPaciente + ", apellidoMaternoPaciente=" + apellidoMaternoPaciente
				+ ", telefonoPaciente=" + telefonoPaciente + ", emailPaciente=" + emailPaciente
				+ ", fechaNacimientoPaciente=" + fechaNacimientoPaciente + ", generoPaciente=" + generoPaciente
				+ ", ciudadResidenciaPaciente=" + ciudadResidenciaPaciente + ", direccionResidenciaPaciente="
				+ direccionResidenciaPaciente + ", codigoAfiliacionPaciente=" + codigoAfiliacionPaciente + "]";
	}
}
