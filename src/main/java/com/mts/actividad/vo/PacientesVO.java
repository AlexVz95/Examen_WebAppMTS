package com.mts.actividad.vo;

public class PacientesVO {
	private int idPaciente;
	private String nombre;
	private String cedula_ide;
	private String telefono;
	private String direccion;
	private int edad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula_ide() {
		return cedula_ide;
	}
	public void setCedula_ide(String cedula_ide) {
		this.cedula_ide = cedula_ide;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	
}
