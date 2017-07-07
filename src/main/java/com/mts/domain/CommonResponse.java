package com.mts.domain;

public class CommonResponse {
	
	private String mensaje;
	private String errorMensaje;
	private boolean success;
	
	public CommonResponse (){};
	
	public CommonResponse (String mensaje,String errorMensaje,boolean success){
		this.errorMensaje = errorMensaje;
		this.mensaje = mensaje;
		this.success = success;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getErrorMensaje() {
		return errorMensaje;
	}

	public void setErrorMensaje(String errorMensaje) {
		this.errorMensaje = errorMensaje;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	};
	
	
	

}
