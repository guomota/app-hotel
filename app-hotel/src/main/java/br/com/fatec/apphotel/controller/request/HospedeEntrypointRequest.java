package br.com.fatec.apphotel.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.fatec.apphotel.modelo.Hospede;
import br.com.fatec.apphotel.repository.HospedeRepository;

public class HospedeEntrypointRequest {
	
	@NotBlank(message =  "O campo nome é obrigátorio")
	private String nome;
	
	@NotBlank(message = "O campo cpf é obrigatório")
	@Pattern(regexp = "[0-9]{11}$", message = "O campo cpf deve conter apenas números com 11 dígitos")
	private String cpf;
	
	@NotBlank(message = "O campo cpf é obrigatório")
	@Pattern(regexp = "[0-9]{8}$", message = "O campo cep deve conter apenas númeors com 8 dígitos")
	private String cep;
	
	@NotBlank(message = "O campo logradouro é obrigatório")
	private String logradouro;
	
	@NotNull(message = "O campo numero é obrigatório")
	private Integer numero;
	
	private String complemento;
	
	@NotBlank(message = "O campo bairro é obrigatório")
	private String bairro;
	
	@NotBlank(message = "O campo ciade é obrigatório")
	private String cidade;
	
	@NotBlank(message = "O campo uf é obrigatório")
	private String uf;
	
	@NotBlank(message = "O campo email é obrigatório")
	private String email;
	
	@NotBlank(message = "O campo telefone é obrigatório")
	private String telefone;

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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		hospede.setNome(this.nome);
		hospede.setCep(this.cep);
		hospede.setLogradouro(this.logradouro);
		hospede.setNumero(this.numero);
		hospede.setComplemento(this.complemento);
		hospede.setBairro(this.bairro);
		hospede.setCidade(this.cidade);
		hospede.setUf(this.uf);
		hospede.setEmail(this.email);
		hospede.setTelefone(this.telefone);
		
		return hospede;
	}

}
