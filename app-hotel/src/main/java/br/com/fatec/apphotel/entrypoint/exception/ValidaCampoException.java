package br.com.fatec.apphotel.entrypoint.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidaCampoException extends Exception {
	
	private static final long serialVersionUID = 8868280108708255265L;
	
	private String erros;
	
	public ValidaCampoException(String erros) {
		this.erros = erros;
		
	}
}
