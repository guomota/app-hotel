package br.com.fatec.apphotel.entrypoint.validation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Classe responsável por mapear a saida do modelo de resposta 
 * da requisção inválida para os erros de BIND
 * 
 * @author Caio Bastos
 * @since 09/10/2020
 *
 */
@Getter
@Builder
@AllArgsConstructor
public class RequisicaoInvalidaModelResponse {

	private String campo;
	private String mensagem;
	private List<ParametroInvalidoModelResponse> campos;
	
	/**
	 * Construtor padrão do modelo
	 */
	public RequisicaoInvalidaModelResponse() {}

	/**
	 * Informa o valor do campo 'campo'
	 * 
	 * @return campo
	 */
	public String getCampo() {
		return campo;
	}

	/**
	 * Define o valor para o campo 'campo' 
	 * 
	 * @param campo {@code String} - Valor para o
	 * 		campo 'campo'
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}

	/**
	 * Informa o valor do campo 'mensagem'
	 * 
	 * @return mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * Define o valor para o campo 'mensagem' 
	 * 
	 * @param mensagem {@code String} - Valor para o
	 * 		campo 'mensagem'
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	/**
	 * Informa o valor do campo 'campos'
	 * 
	 * @return campos
	 */
	public List<ParametroInvalidoModelResponse> getCampos() {
		return campos;
	}

	/**
	 * Define o valor para o campo 'campos' 
	 * 
	 * @param mensagem {@code ParametroInvalidoModelResponse} - Valor para o
	 * 		campo 'campos'
	 */
	public void setCampos(List<ParametroInvalidoModelResponse> campos) {
		this.campos = campos;
	}
}
