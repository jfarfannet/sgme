package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanEstudio {

	@JsonProperty("C_CodigoPlanEstudio")
	private String codigo;
	
	@JsonProperty("C_Descripcion")
	private String nombre;
	
	@JsonProperty("C_CodigoCarrera")
	private String codcarrera;

	@JsonProperty("N_CreditosObligatorios")
	private Integer creditos;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodcarrera() {
		return codcarrera;
	}

	public void setCodcarrera(String codcarrera) {
		this.codcarrera = codcarrera;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "PlanEstudio ["
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (codcarrera != null ? "codcarrera=" + codcarrera + ", " : "")
				+ (creditos != null ? "creditos=" + creditos : "") + "]";
	}

}
