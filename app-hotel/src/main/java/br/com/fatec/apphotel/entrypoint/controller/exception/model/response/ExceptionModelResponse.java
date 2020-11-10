package br.com.fatec.apphotel.entrypoint.controller.exception.model.response;

/**
 * Classe responsável por mapear o modelo de resposta
 * das exceções.
 * 
 * @author Caio Bastos
 * @since 08/10/2020
 *
 */
public class ExceptionModelResponse {

	private String codigo;
	private String mensagem;
	
	/**
	 * Construtor padrão vazio
	 */
	public ExceptionModelResponse() {}
	
	/**
	 * Informa o valor do campo 'codigo'
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Define o valor para o campo 'codigo' 
	 * 
	 * @param codigo {@code String} - Valor para o
	 * 		campo 'codigo'
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
