package br.com.fatec.apphotel.configuration.validacao;

/**
 * Classe responsável por mapear o campo e o 
 * erro na validação dos campos de entarda
 * 
 * @author Gustavo Mota
 * @since 18/11/2020
 *
 */
public class ValidacaoCamposDTO {
	
	private String campo;
	private String erro;
	
	public ValidacaoCamposDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
