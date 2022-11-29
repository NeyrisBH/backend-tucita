package com.tucita.medicalteam.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("orders")
public class OrdenesRemisiones {

	@Id
	private Long id;
	private String tipoExamen;
	private String lugarProcedimiento;
	private String fechaProcedimiento;
	private String paciente;
	private Long idMedicoGeneral;

	public OrdenesRemisiones(Long id, String tipoExamen, String lugarProcedimiento, String fechaProcedimiento,
			String paciente, Long idMedicoGeneral) {
		super();
		this.id = id;
		this.tipoExamen = tipoExamen;
		this.lugarProcedimiento = lugarProcedimiento;
		this.fechaProcedimiento = fechaProcedimiento;
		this.paciente = paciente;
		this.idMedicoGeneral = idMedicoGeneral;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(String tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public String getLugarProcedimiento() {
		return lugarProcedimiento;
	}

	public void setLugarProcedimiento(String lugarProcedimiento) {
		this.lugarProcedimiento = lugarProcedimiento;
	}

	public String getFechaProcedimiento() {
		return fechaProcedimiento;
	}

	public void setFechaProcedimiento(String fechaProcedimiento) {
		this.fechaProcedimiento = fechaProcedimiento;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public Long getIdMedicoGeneral() {
		return idMedicoGeneral;
	}

	public void setIdMedicoGeneral(Long idMedicoGeneral) {
		this.idMedicoGeneral = idMedicoGeneral;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaProcedimiento, id, idMedicoGeneral, lugarProcedimiento, paciente, tipoExamen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenesRemisiones other = (OrdenesRemisiones) obj;
		return Objects.equals(fechaProcedimiento, other.fechaProcedimiento) && Objects.equals(id, other.id)
				&& Objects.equals(idMedicoGeneral, other.idMedicoGeneral)
				&& Objects.equals(lugarProcedimiento, other.lugarProcedimiento)
				&& Objects.equals(paciente, other.paciente) && Objects.equals(tipoExamen, other.tipoExamen);
	}

	@Override
	public String toString() {
		return "OrdenesRemisiones [id=" + id + ", tipoExamen=" + tipoExamen + ", lugarProcedimiento="
				+ lugarProcedimiento + ", fechaProcedimiento=" + fechaProcedimiento + ", paciente=" + paciente
				+ ", idMedicoGeneral=" + idMedicoGeneral + "]";
	}

}