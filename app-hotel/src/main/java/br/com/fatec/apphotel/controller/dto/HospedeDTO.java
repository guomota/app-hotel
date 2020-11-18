package br.com.fatec.apphotel.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fatec.apphotel.modelo.Hospede;

public class HospedeDTO {
	
	private String nome;
	private String cpf;
	private String cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String email;	
	private String telefone;
	
	public HospedeDTO(Hospede hospede) {
		super();
		this.nome = hospede.getNome();
		this.cpf = hospede.getCpf();
		this.cep = hospede.getCep();
		this.logradouro = hospede.getLogradouro();
		this.numero = hospede.getNumero();
		this.complemento = hospede.getComplemento();
		this.bairro = hospede.getBairro();
		this.cidade = hospede.getCidade();
		this.uf = hospede.getUf();
		this.email = hospede.getEmail();
		this.telefone = hospede.getTelefone();
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getCep() {
		return cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getUf() {
		return uf;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public static List<HospedeDTO> converter(List<Hospede> hospedes) {
		return hospedes.stream().map(HospedeDTO::new).collect(Collectors.toList());
	}
}
