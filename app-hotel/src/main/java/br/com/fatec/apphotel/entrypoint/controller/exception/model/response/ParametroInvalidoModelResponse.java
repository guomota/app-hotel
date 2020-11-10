package br.com.fatec.apphotel.entrypoint.controller.exception.model.response;

/**
 * Classe responsável por mapear a saida do modelo de resposta 
 * dos parametros inválidos para os erros de BIND
 * 
 * @author Caio Bastos
 * @since 09/10/2020
 *
 */
public class ParametroInvalidoModelResponse {

	private String campo;
	private String mensagem;
	
	/**
	 * Construtor padrão do modelo
	 */
	public ParametroInvalidoModelResponse() {}
	
	/**
	 * Construtor padrão do modelo
	 */
	public ParametroInvalidoModelResponse(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem =  mensagem;
	}

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
}
