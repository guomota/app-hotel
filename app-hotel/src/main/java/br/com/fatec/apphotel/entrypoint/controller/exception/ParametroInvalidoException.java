package br.com.fatec.apphotel.entrypoint.controller.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável por mapear o a excação do tipo
 * <b>BAD REQUEST</b> com o codigo 400, quando um recurso
 * nao existe.
 * 
 * @author Caio Bastos
 * @since 08/10/2020
 *
 */
public class ParametroInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 3578736292376464933L;
	private Map<String, List<String>> erros;
	
	/**
	 * Construtor para modelar a resposta das exceções.
	 * 
	 * @param texto - Texto para montar nos erros de bind.
	 */
	public ParametroInvalidoException(String texto) {
		super(texto);
		this.erros = new HashMap<>();
	}
	
	/**
	 * Informa o valor do campo 'erros'
	 * 
	 * @return {@code Map<String, List<String>>} - erros
	 */
	public Map<String, List<String>> getErros() {
		return erros;
	}
	
	/**
	 * Define o valor para o campo 'erros' 
	 * 
	 * @param erros {@code Map<String, List<String>>} - Valor para o
	 * 		campo 'erros'
	 */
	public void setErros(Map<String, List<String>> erros) {
		this.erros = erros;
	}
}
