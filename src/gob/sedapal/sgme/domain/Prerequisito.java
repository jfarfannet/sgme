package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prerequisito {

	@JsonProperty("C_CodigoCurso")
	private String codcurso;
	
	@JsonProperty("C_CodigoCursoPrerequisito")
	private String codprerequisito;
	
	@JsonProperty("C_CodigoPlanEstudio")
	private String codplanestudio;

	public String getCodcurso() {
		return codcurso;
	}

	public void setCodcurso(String codcurso) {
		this.codcurso = codcurso;
	}

	public String getCodprerequisito() {
		return codprerequisito;
	}

	public void setCodprerequisito(String codprerequisito) {
		this.codprerequisito = codprerequisito;
	}

	public String getCodplanestudio() {
		return codplanestudio;
	}

	public void setCodplanestudio(String codplanestudio) {
		this.codplanestudio = codplanestudio;
	}

	@Override
	public String toString() {
		return "Prerequisito ["
				+ (codcurso != null ? "codcurso=" + codcurso + ", " : "")
				+ (codprerequisito != null ? "codprerequisito="
						+ codprerequisito + ", " : "")
				+ (codplanestudio != null ? "codplanestudio=" + codplanestudio
						: "") + "]";
	}

}
