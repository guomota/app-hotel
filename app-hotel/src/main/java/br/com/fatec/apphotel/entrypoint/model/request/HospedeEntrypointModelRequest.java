package br.com.fatec.apphotel.entrypoint.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe entidade do hóspde
 * 
 * @author Gustavo Mota
 * @since 09/11/2020
 */
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class HospedeEntrypointModelRequest {
	
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
}
