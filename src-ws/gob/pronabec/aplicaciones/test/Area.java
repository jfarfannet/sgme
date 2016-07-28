package gob.pronabec.aplicaciones.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="area")
public class Area {

	private Integer codpadre;
	
	private Integer id;
	
	private String nombre;
	
	private String lugar;
	
	private Integer escurso;
	
	private Integer esvirtual;
	
	private Integer esevento;

	public Integer getCodpadre() {
		return codpadre;
	}

	@XmlElement(name="CODPADRE")
	public void setCodpadre(Integer codpadre) {
		this.codpadre = codpadre;
	}

	public Integer getId() {
		return id;
	}

	@XmlElement(name="ID")
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	@XmlElement(name="NOMBRE")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	@XmlElement(name="LUGAR")
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Integer getEscurso() {
		return escurso;
	}

	@XmlElement(name="ESCURSO")
	public void setEscurso(Integer escurso) {
		this.escurso = escurso;
	}

	public Integer getEsvirtual() {
		return esvirtual;
	}

	@XmlElement(name="ESVIRTUAL")
	public void setEsvirtual(Integer esvirtual) {
		this.esvirtual = esvirtual;
	}

	public Integer getEsevento() {
		return esevento;
	}

	@XmlElement(name="ESEVENTO")
	public void setEsevento(Integer esevento) {
		this.esevento = esevento;
	}

	@Override
	public String toString() {
		return "Area ["
				+ (codpadre != null ? "codpadre=" + codpadre + ", " : "")
				+ (id != null ? "id=" + id + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (lugar != null ? "lugar=" + lugar + ", " : "")
				+ (escurso != null ? "escurso=" + escurso + ", " : "")
				+ (esvirtual != null ? "esvirtual=" + esvirtual + ", " : "")
				+ (esevento != null ? "esevento=" + esevento : "") + "]";
	}
	
}
