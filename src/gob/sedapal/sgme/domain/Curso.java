package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Curso {

	@JsonProperty("C_Ciclo")
	private Integer ciclo;
	
	@JsonProperty("C_CodigoCurso")
	private String codigo;
	
	@JsonProperty("C_CodigoPlanEstudio")
	private String codplanestudio;

	@JsonProperty("C_Creditos")
	private Double creditos;
	
	@JsonProperty("C_Descripcion")
	private String nombre;
	
	@JsonProperty("C_Tipo")
	private String tipo;
	
	@JsonProperty("N_HorasProgramadas")
	private Integer horas;
	
	@JsonProperty("N_NotaMinima")
	private Double minnota;
	
	@JsonProperty("N_PocentajeAsistencia")
	private Double minasistencia;

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodplanestudio() {
		return codplanestudio;
	}

	public void setCodplanestudio(String codplanestudio) {
		this.codplanestudio = codplanestudio;
	}

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Double getMinnota() {
		return minnota;
	}

	public void setMinnota(Double minnota) {
		this.minnota = minnota;
	}

	public Double getMinasistencia() {
		return minasistencia;
	}

	public void setMinasistencia(Double minasistencia) {
		this.minasistencia = minasistencia;
	}

	@Override
	public String toString() {
		return "Curso ["
				+ (ciclo != null ? "ciclo=" + ciclo + ", " : "")
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ (codplanestudio != null ? "codplanestudio=" + codplanestudio
						+ ", " : "")
				+ (creditos != null ? "creditos=" + creditos + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (tipo != null ? "tipo=" + tipo + ", " : "")
				+ (horas != null ? "horas=" + horas + ", " : "")
				+ (minnota != null ? "minnota=" + minnota + ", " : "")
				+ (minasistencia != null ? "minasistencia=" + minasistencia
						: "") + "]";
	}

}
