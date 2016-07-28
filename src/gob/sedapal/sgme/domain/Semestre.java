package gob.sedapal.sgme.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Semestre {

	@JsonProperty("C_CodSemestre")
	private String codigo;
	
	@JsonProperty("C_Descripcion")
	private String descripcion;
	
	@JsonProperty("F_FechaInicio")
	private String fecinicioString;
	
	@JsonProperty("F_FechaTermino")
	private String fecfinString;

	private Date fecinicio;
	
	private Date fecfin;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecinicio() {
		return fecinicio;
	}

	public void setFecinicio(Date fecinicio) {
		this.fecinicio = fecinicio;
	}

	public Date getFecfin() {
		return fecfin;
	}

	public void setFecfin(Date fecfin) {
		this.fecfin = fecfin;
	}

	public String getFecinicioString() {
		return "/Date(" + this.fecinicio.getTime()+")/";
	}

	public String getFecfinString() {
		return "/Date(" + this.fecfin.getTime()+")/";
	}

	@Override
	public String toString() {
		return "Semestre ["
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ (descripcion != null ? "descripcion=" + descripcion + ", "
						: "")
				+ (fecinicio != null ? "fecinicio=" + fecinicio + ", " : "")
				+ (fecfin != null ? "fecfin=" + fecfin : "") + "]";
	}

}
