package br.com.fatec.apphotel.configuration.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Classe responsável por mapear o erro de validação de campos e montar o body de resposta
 * 
 * @author Gustavo Mota
 * @since 05/12/2020
 *
 */
@RestControllerAdvice
public class ValidacaoCamposHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ValidacaoCamposDTO> handle( MethodArgumentNotValidException exception) {

		List<ValidacaoCamposDTO> validacaoCamposDTO = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(fieldError -> {
			String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			ValidacaoCamposDTO erro = new ValidacaoCamposDTO(fieldError.getField(), mensagem);
			validacaoCamposDTO.add(erro);
		});

		return validacaoCamposDTO;
	}
}
