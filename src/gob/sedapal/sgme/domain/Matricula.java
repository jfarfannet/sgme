package gob.sedapal.sgme.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Matricula {

	@JsonProperty("C_CodAlumno")
	private String codalumno;
	
	@JsonProperty("C_CodMatricula")
	private String codmatricula;
	
	@JsonProperty("C_CodSemestre")
	private String codsemestre;
	
	@JsonProperty("C_NroDni")
	private String dni;
	
	@JsonProperty("F_FechaMatricula")
	private String fechaString;
	
	private Date fecha;
	
	@JsonProperty("C_IdCarrera")
	private String codcarrera;
	
	@JsonProperty("C_CodigoPlan")
	private String codplanestudio;
	
	@JsonProperty("C_CodSede")
	private String sede;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaString() {
		return "/Date(" + this.fecha.getTime()+")/";
	}

	public String getCodalumno() {
		return codalumno;
	}

	public void setCodalumno(String codalumno) {
		this.codalumno = codalumno;
	}

	public String getCodmatricula() {
		return codmatricula;
	}

	public void setCodmatricula(String codmatricula) {
		this.codmatricula = codmatricula;
	}

	public String getCodsemestre() {
		return codsemestre;
	}

	public void setCodsemestre(String codsemestre) {
		this.codsemestre = codsemestre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodcarrera() {
		return codcarrera;
	}

	public void setCodcarrera(String codcarrera) {
		this.codcarrera = codcarrera;
	}

	public String getCodplanestudio() {
		return codplanestudio;
	}

	public void setCodplanestudio(String codplanestudio) {
		this.codplanestudio = codplanestudio;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	@Override
	public String toString() {
		return "Matricula ["
				+ (codalumno != null ? "codalumno=" + codalumno + ", " : "")
				+ (codmatricula != null ? "codmatricula=" + codmatricula + ", "
						: "")
				+ (codsemestre != null ? "codsemestre=" + codsemestre + ", "
						: "")
				+ (dni != null ? "dni=" + dni + ", " : "")
				+ (fechaString != null ? "fechaString=" + fechaString + ", "
						: "")
				+ (fecha != null ? "fecha=" + fecha + ", " : "")
				+ (codcarrera != null ? "codcarrera=" + codcarrera + ", " : "")
				+ (codplanestudio != null ? "codplanestudio=" + codplanestudio
						+ ", " : "") + (sede != null ? "sede=" + sede : "")
				+ "]";
	}

}
