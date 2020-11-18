package br.com.fatec.apphotel.config.validacao;

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
