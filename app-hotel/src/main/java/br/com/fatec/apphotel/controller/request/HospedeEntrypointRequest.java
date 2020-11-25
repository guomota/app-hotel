package br.com.fatec.apphotel.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.fatec.apphotel.modelo.Hospede;
import br.com.fatec.apphotel.repository.HospedeRepository;

public class HospedeEntrypointRequest {
	
	@NotBlank(message =  "O campo nome é obrigátorio")
	private String nome;
	
	@NotBlank(message = "O campo rg é obrigatório")
	private String rg;
	
	@NotBlank(message = "O campo cpf é obrigatório")
	@Pattern(regexp = "[0-9]{11}$", message = "O campo cpf deve conter apenas números com 11 dígitos")
	private String cpf;
		
	@NotBlank(message = "O campo email é obrigatório")
	private String email;
	
	@NotBlank(message = "O campo telefone é obrigatório")
	private String telefone;

	public String getNome() {
		return nome;
	}
	
	public String getRg() {
		return rg;
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Hospede atualizar(Long id, HospedeRepository hospedeRepository) {
		Hospede hospede = hospedeRepository.getOne(id);
		
		hospede.setCpf(this.cpf);
		hospede.setRg(this.rg);
		hospede.setNome(this.nome);
		hospede.setEmail(this.email);
		hospede.setTelefone(this.telefone);
		
		return hospede;
	}

}
