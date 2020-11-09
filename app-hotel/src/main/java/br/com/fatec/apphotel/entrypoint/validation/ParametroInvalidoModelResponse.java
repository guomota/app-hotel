package br.com.fatec.apphotel.entrypoint.validation;

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
	private String valor;
	
	/**
	 * Construtor padrão do modelo
	 */
	public ParametroInvalidoModelResponse() {}
	
	public ParametroInvalidoModelResponse(String campo, String mensagem) {
		this.setCampo(campo);
		this.setMensagem(mensagem);		
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

	/**
	 * Informa o valor do campo 'valor'
	 * 
	 * @return valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Define o valor para o campo 'valor' 
	 * 
	 * @param valor {@code String} - Valor para o
	 * 		campo 'valor'
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
}
