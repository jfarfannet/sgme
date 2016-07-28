package gob.sedapal.sgme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Becario {
	
	@JsonProperty("ModalidadBeca") // Usar @JsonProperty porque la 1era letra es mayuscula
	private String modalidadBeca;
	
	@JsonProperty("Ies")
	private String ies;
	
	@JsonProperty("Sede")
	private String sede;
	
	@JsonProperty("Carrera")
	private String carrera;
	
	@JsonProperty("NombreCompleto")
	private String nombreCompleto;
	
	@JsonProperty("Dni")
	private String dni;
	
	public String getModalidadBeca() {
		return modalidadBeca;
	}

	public void setModalidadBeca(String modalidadBeca) {
		this.modalidadBeca = modalidadBeca;
	}

	public String getIes() {
		return ies;
	}
	
	public void setIes(String ies) {
		this.ies = ies;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Becario ["
				+ (modalidadBeca != null ? "modalidadBeca=" + modalidadBeca
						+ ", " : "")
				+ (ies != null ? "ies=" + ies + ", " : "")
				+ (sede != null ? "sede=" + sede + ", " : "")
				+ (carrera != null ? "carrera=" + carrera + ", " : "")
				+ (nombreCompleto != null ? "nombreCompleto=" + nombreCompleto
						+ ", " : "") + (dni != null ? "dni=" + dni : "") + "]";
	}
	
}
