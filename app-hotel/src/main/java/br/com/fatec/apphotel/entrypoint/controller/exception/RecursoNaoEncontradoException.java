package br.com.fatec.apphotel.entrypoint.controller.exception;

/**
 * Classe responsável por mapear o a excação do tipo
 * <b>NOT FOUND</b> com o codigo 404, quando um recurso
 * nao existe.
 * 
 * @author Caio Bastos
 * @since 08/10/2020
 *
 */
public class RecursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 4855464415989494282L;
	
	/**
	 * Construtor padrão para montagem de saída de resposta
	 * 
	 * @param texto
	 */
	public RecursoNaoEncontradoException(String texto) {
		super(texto);
	}
}
