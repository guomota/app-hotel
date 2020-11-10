package br.com.fatec.apphotel.entrypoint.controller.exception;

/**
 * Classe responsável por mapear o a excação do tipo
 * <b>SERVER UNAVAILABLE</b> com o codigo 503, quando um recurso
 * nao existe.
 * 
 * @author Caio Bastos
 * @since 08/10/2020
 *
 */
public class ServidorIndisponivelException extends RuntimeException {

	private static final long serialVersionUID = -8852914568273853742L;

	/**
	 * Construtor padrão para montagem de saída de resposta
	 * 
	 * @param texto
	 */
	public ServidorIndisponivelException(String texto) {
		super(texto);
	}
}
