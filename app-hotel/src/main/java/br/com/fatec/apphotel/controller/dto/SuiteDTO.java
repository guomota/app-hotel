package br.com.fatec.apphotel.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fatec.apphotel.modelo.Suite;

public class SuiteDTO {
	
	private String tipo;
	private Double valorDiaria;
	private String disponivel;
	
	public SuiteDTO(Suite suite) {
		super();
		this.tipo = suite.getTipo();
		this.valorDiaria = suite.getValorDiaria();
		this.disponivel = suite.getDisponivel();
	}

	public String getTipo() {
		return tipo;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public String getDisponivel() {
		return disponivel;
	}
	
	public static List<SuiteDTO> converter(List<Suite> suites) {
		return suites.stream().map(SuiteDTO::new).collect(Collectors.toList());
	}
}
