package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sede {

	@JsonProperty("C_CodSede")
	private String codigo;
	
	@JsonProperty("C_DenominacionSede")
	private String denominacion;
	
	@JsonProperty("C_Ubicacion")
	private String ubicacion;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Sede ["
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ (denominacion != null ? "denominacion=" + denominacion + ", "
						: "")
				+ (ubicacion != null ? "ubicacion=" + ubicacion : "") + "]";
	}
	
}
