package br.com.fatec.apphotel.entrypoint.controller.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fatec.apphotel.entrypoint.controller.exception.model.response.ExceptionModelResponse;
import br.com.fatec.apphotel.entrypoint.controller.exception.model.response.ParametroInvalidoModelResponse;
import br.com.fatec.apphotel.entrypoint.controller.exception.model.response.RequisicaoInvalidaModelResponse;


/**
 * Classe responsável por fazer os tratamentos das exceções
 * na aplicação.
 * 
 * @author Caio Bastos
 * @since 06/10/2020O
 *
 */
@ControllerAdvice
@RestController
public class HandlerControllerException extends ResponseEntityExceptionHandler {

	/**
	 * Método responsável por capturar as exceções na apliacação do tipo <b>NOT FOUND</b>
	 * e tratar a exceção com o código 404
	 * @param exception
	 * @param webRequest
	 * 
	 * @return {@code ResponseEntity<>} - O JSON com o código e a mensagem
	 * 		do tipo NOT FOUND 
	 */
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public final ResponseEntity<ExceptionModelResponse> handleNotFound(Exception exception, WebRequest webRequest){
		
		return this.handleNotFound(exception);
	}
	
	/**
	 * Método responsável por capturar as exceções na apliacação do tipo <b>SERVER UNAVAILABLE</b>
	 * e tratar a exceção com o código 503
	 * @param exception
	 * @param webRequest
	 * 
	 * @return {@code ResponseEntity<>} - O JSON com o código e a mensagem
	 * 		do tipo SERVER UNAVAILABLE
	 */
	@ExceptionHandler(ServidorIndisponivelException.class)
	public final ResponseEntity<ExceptionModelResponse> handleServerUnavailableException(Exception exception, WebRequest webRequest){
		
		return this.handleServerUnavailableException(exception);
	}
	
	/**
	 * Método responsável por capturar as exceções na apliacação do tipo <b>BAD REQUEST</b>
	 * e tratar a exceção com o código 400
	 * @param exception
	 * @param webRequest
	 * 
	 * @return {@code ResponseEntity<>} - O JSON com o código e a mensagem
	 * 		do tipo BAD REQUEST 
	 */
	@ExceptionHandler(ParametroInvalidoException.class)
	public ResponseEntity<RequisicaoInvalidaModelResponse> handleBindException(ParametroInvalidoException exception,
			WebRequest webRequest) {
		
		return new ResponseEntity<RequisicaoInvalidaModelResponse>(montaBodyErroBind(exception), getHeaders(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Método por montar a exceção do tipo NotFound da aplicação
	 * 
	 * @param exception
	 * 
	 * @return {@code ResponseEntity<>} - O JSON com o código e a mensagem
	 * 		do tipo NOT FOUND 
	 */
	private ResponseEntity<ExceptionModelResponse> handleNotFound(Exception exception) {
		
		ExceptionModelResponse exceptionModelResponse = new ExceptionModelResponse();
		exceptionModelResponse.setCodigo(String.valueOf(HttpStatus.NOT_FOUND.value()));
		exceptionModelResponse.setMensagem(exception.getMessage());
		
		return new ResponseEntity<ExceptionModelResponse>(exceptionModelResponse, getHeaders(), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Método por montar a exceção do tipo ServerUnavailable da aplicação
	 * 
	 * @param exception
	 * 
	 * @return {@code ResponseEntity<>} - O JSON com o código e a mensagem
	 * 		do tipo SERVER UNAVAILABLE 
	 */
	private ResponseEntity<ExceptionModelResponse> handleServerUnavailableException(Exception exception) {
		
		ExceptionModelResponse exceptionModelResponse = new ExceptionModelResponse();
		exceptionModelResponse.setCodigo(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()));
		exceptionModelResponse.setMensagem(exception.getMessage());
		
		return new ResponseEntity<ExceptionModelResponse>(exceptionModelResponse, getHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	/**
	 * Método responsável por montar o body da aplicação
	 * quando há erro de bind, com exceção do tipo BAD REQUEST.
	 * 
	 * @param exception
	 * 
	 * @return {@code RequisicaoInvalidaModelResponse} - Body de saida
	 */
	private RequisicaoInvalidaModelResponse montaBodyErroBind(ParametroInvalidoException exception) {

		List<ParametroInvalidoModelResponse> parametrosInvalidos = new ArrayList<ParametroInvalidoModelResponse>();
		Map<String, List<String>> errosCampos = exception.getErros();
		errosCampos.forEach((chave, mensagem) -> {
			ParametroInvalidoModelResponse parametroInvalidoResponse = new ParametroInvalidoModelResponse();
			parametroInvalidoResponse.setCampo(chave);
			parametroInvalidoResponse.setMensagem(mensagem.get(0));
			
			parametrosInvalidos.add(parametroInvalidoResponse);
		});
		
		RequisicaoInvalidaModelResponse requisicaoInvalidaResponse = new RequisicaoInvalidaModelResponse();
		requisicaoInvalidaResponse.setCampo("validation_error");
		requisicaoInvalidaResponse.setMensagem("Erro na validação de campos");
		requisicaoInvalidaResponse.setCampos(parametrosInvalidos);
		
		return requisicaoInvalidaResponse;
	}
	
	/**
	 * Método responsável por montar a saída no tipo JSON
	 * 
	 * @return {@code HttpHeaders} - Tipo APPLICATION_JSON
	 */
	private HttpHeaders getHeaders() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return responseHeaders;
	}
}
