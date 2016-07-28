package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nota {

	@JsonProperty("C_CodMatricula")
	private String codmatricula;
	
	@JsonProperty("C_CodigoCurso")
	private String codcurso;
	
	@JsonProperty("C_Condicion")
	private String condicion;

	@JsonProperty("N_Nota")
	private Double nota;

	public String getCodmatricula() {
		return codmatricula;
	}

	public void setCodmatricula(String codmatricula) {
		this.codmatricula = codmatricula;
	}

	public String getCodcurso() {
		return codcurso;
	}

	public void setCodcurso(String codcurso) {
		this.codcurso = codcurso;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota ["
				+ (codmatricula != null ? "codmatricula=" + codmatricula + ", "
						: "")
				+ (codcurso != null ? "codcurso=" + codcurso + ", " : "")
				+ (condicion != null ? "condicion=" + condicion + ", " : "")
				+ (nota != null ? "nota=" + nota : "") + "]";
	}

}
