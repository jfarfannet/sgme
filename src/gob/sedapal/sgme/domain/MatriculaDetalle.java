package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatriculaDetalle {

	@JsonProperty("C_CodMatricula")
	private String codmatricula;
	
	@JsonProperty("C_CodigoCurso")
	private String codcurso;

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

	@Override
	public String toString() {
		return "MatriculaDetalle ["
				+ (codmatricula != null ? "codmatricula=" + codmatricula + ", "
						: "")
				+ (codcurso != null ? "codcurso=" + codcurso : "") + "]";
	}
	
}
