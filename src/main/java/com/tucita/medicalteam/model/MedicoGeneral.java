package com.tucita.medicalteam.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("medic")
public class MedicoGeneral {
	
	@Id
	private Long id;
	private String nombreMedico;
	private String apellidoPaternoMedico;
	private String apellidoMaternoMedico;
	private Long telefonoMedico;
	private String areaMedico;
	private String remision;
	
	public MedicoGeneral() {
		super();
	}

	public MedicoGeneral(Long id, String nombreMedico, String apellidoPaternoMedico, String apellidoMaternoMedico,
			Long telefonoMedico, String areaMedico, String remision) {
		super();
		this.id = id;
		this.nombreMedico = nombreMedico;
		this.apellidoPaternoMedico = apellidoPaternoMedico;
		this.apellidoMaternoMedico = apellidoMaternoMedico;
		this.telefonoMedico = telefonoMedico;
		this.areaMedico = areaMedico;
		this.remision = remision;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getApellidoPaternoMedico() {
		return apellidoPaternoMedico;
	}

	public void setApellidoPaternoMedico(String apellidoPaternoMedico) {
		this.apellidoPaternoMedico = apellidoPaternoMedico;
	}

	public String getApellidoMaternoMedico() {
		return apellidoMaternoMedico;
	}

	public void setApellidoMaternoMedico(String apellidoMaternoMedico) {
		this.apellidoMaternoMedico = apellidoMaternoMedico;
	}

	public Long getTelefonoMedico() {
		return telefonoMedico;
	}

	public void setTelefonoMedico(Long telefonoMedico) {
		this.telefonoMedico = telefonoMedico;
	}

	public String getAreaMedico() {
		return areaMedico;
	}

	public void setAreaMedico(String areaMedico) {
		this.areaMedico = areaMedico;
	}

	public String getRemision() {
		return remision;
	}

	public void setRemision(String remision) {
		this.remision = remision;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaternoMedico, apellidoPaternoMedico, areaMedico, id, nombreMedico, remision,
				telefonoMedico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicoGeneral other = (MedicoGeneral) obj;
		return Objects.equals(apellidoMaternoMedico, other.apellidoMaternoMedico)
				&& Objects.equals(apellidoPaternoMedico, other.apellidoPaternoMedico)
				&& Objects.equals(areaMedico, other.areaMedico) && Objects.equals(id, other.id)
				&& Objects.equals(nombreMedico, other.nombreMedico) && Objects.equals(remision, other.remision)
				&& Objects.equals(telefonoMedico, other.telefonoMedico);
	}

	@Override
	public String toString() {
		return "MedicoGeneral [id=" + id + ", nombreMedico=" + nombreMedico + ", apellidoPaternoMedico="
				+ apellidoPaternoMedico + ", apellidoMaternoMedico=" + apellidoMaternoMedico + ", telefonoMedico="
				+ telefonoMedico + ", areaMedico=" + areaMedico + ", remision=" + remision + "]";
	}
}
