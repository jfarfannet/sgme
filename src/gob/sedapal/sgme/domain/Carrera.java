package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carrera {

	@JsonProperty("C_CodCarrera")
	private String codigo;
	
	@JsonProperty("C_NombreCarrera")
	private String nombre;
	
	@JsonProperty("C_IdFacultad")
	private String codfacultad;

	@JsonProperty("C_Nombrefacultad")
	private String nomfacultad;
	
	@JsonProperty("C_CodSede")
	private String sede;

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

	public String getCodfacultad() {
		return codfacultad;
	}

	public void setCodfacultad(String codfacultad) {
		this.codfacultad = codfacultad;
	}

	public String getNomfacultad() {
		return nomfacultad;
	}

	public void setNomfacultad(String nomfacultad) {
		this.nomfacultad = nomfacultad;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	@Override
	public String toString() {
		return "Carrera ["
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (codfacultad != null ? "codfacultad=" + codfacultad + ", "
						: "")
				+ (nomfacultad != null ? "nomfacultad=" + nomfacultad + ", "
						: "") + (sede != null ? "sede=" + sede : "") + "]";
	}

}
