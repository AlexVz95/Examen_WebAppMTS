package com.mts.actividad.vo;

public class SustanciasVO {
	private int idSustancias;
	private int idMedicamentos;
	private String nombre;
	private String codigo_sus;
	private boolean combinacion;
	public int getIdSustancias() {
		return idSustancias;
	}
	public void setIdSustancias(int idSustancias) {
		this.idSustancias = idSustancias;
	}
	public int getIdMedicamentos() {
		return idMedicamentos;
	}
	public void setIdMedicamentos(int idMedicamentos) {
		this.idMedicamentos = idMedicamentos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo_sus() {
		return codigo_sus;
	}
	public void setCodigo_sus(String codigo_sus) {
		this.codigo_sus = codigo_sus;
	}
	public boolean isCombinacion() {
		return combinacion;
	}
	public void setCombinacion(boolean combinacion) {
		this.combinacion = combinacion;
	}
	
}
