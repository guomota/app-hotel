package br.com.fatec.apphotel.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fatec.apphotel.modelo.Hospede;

public class HospedeDTO {
	
	private String nome;
	private String rg;
	private String cpf;
	private String email;	
	private String telefone;
	
	public HospedeDTO(Hospede hospede) {
		super();
		this.nome = hospede.getNome();
		this.cpf = hospede.getCpf();
		this.rg = hospede.getRg();
		this.email = hospede.getEmail();
		this.telefone = hospede.getTelefone();
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public String getRg() {
		return rg;
	}
	
	public static List<HospedeDTO> converter(List<Hospede> hospedes) {
		return hospedes.stream().map(HospedeDTO::new).collect(Collectors.toList());
	}
}
