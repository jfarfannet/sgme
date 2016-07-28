package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Asistencia {

	@JsonProperty("C_CodigoCurso")
	private String codcurso;
	
	@JsonProperty("C_DescripcionCurso")
	private String descripcion;
	
	@JsonProperty("C_NroDni")
	private String dni;

	@JsonProperty("C_CodAlumno")
	private String codalumno;
	
	@JsonProperty("DateTimeInicio")
	private String fecinicio;
	
	@JsonProperty("DateTimeTermino")
	private String fecfin;
	
	@JsonProperty("Opcion")
	private Integer opcion;
	
	@JsonProperty("Tipo")
	private String tipo;

	public String getCodcurso() {
		return codcurso;
	}

	public void setCodcurso(String codcurso) {
		this.codcurso = codcurso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodalumno() {
		return codalumno;
	}

	public void setCodalumno(String codalumno) {
		this.codalumno = codalumno;
	}

	public String getFecinicio() {
		return fecinicio;
	}

	public void setFecinicio(String fecinicio) {
		this.fecinicio = fecinicio;
	}

	public String getFecfin() {
		return fecfin;
	}

	public void setFecfin(String fecfin) {
		this.fecfin = fecfin;
	}

	public Integer getOpcion() {
		return opcion;
	}

	public void setOpcion(Integer opcion) {
		this.opcion = opcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Asistencia ["
				+ (codcurso != null ? "codcurso=" + codcurso + ", " : "")
				+ (descripcion != null ? "descripcion=" + descripcion + ", "
						: "") + (dni != null ? "dni=" + dni + ", " : "")
				+ (codalumno != null ? "codalumno=" + codalumno + ", " : "")
				+ (fecinicio != null ? "fecinicio=" + fecinicio + ", " : "")
				+ (fecfin != null ? "fecfin=" + fecfin + ", " : "")
				+ (opcion != null ? "opcion=" + opcion + ", " : "")
				+ (tipo != null ? "tipo=" + tipo : "") + "]";
	}

}
