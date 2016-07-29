package gob.sedapal.sgme.domain;

public class Roles {
	private int idRol;
	private String descRol;
	private String estado;
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getDescRol() {
		return descRol;
	}
	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Roles [idRol=" + idRol + ", descRol=" + descRol + ", estado=" + estado + "]";
	}
	
	
	
}
