package br.com.fatec.apphotel.controller.request;

import javax.validation.constraints.NotBlank;

import br.com.fatec.apphotel.modelo.Suite;
import br.com.fatec.apphotel.repository.SuiteRepository;

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
	
	public Suite atualizar(Long id, SuiteRepository suiteRepository) {
		
		Suite suite = suiteRepository.getOne(id);
		
		suite.setDisponivel(this.status);
		suite.setTipo(this.tipo);
		suite.setValorDiaria(this.valor);
		
		return suite;
	}
}
