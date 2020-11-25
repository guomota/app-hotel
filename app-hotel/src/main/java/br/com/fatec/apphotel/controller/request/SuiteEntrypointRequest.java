package br.com.fatec.apphotel.controller.request;

import javax.validation.constraints.NotBlank;

public class SuiteEntrypointRequest {
	
	@NotBlank(message =  "O campo tipo é obrigátorio")
	private String tipo;
	
	private Double valor;
	
	private String status;
	
	public String getTipo() {
		return tipo;
	}
	public Double getValor() {
		return valor;
	}
	public String getStatus() {
		return status;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
