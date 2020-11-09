package br.com.fatec.apphotel.entrypoint.validation;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.fatec.apphotel.entrypoint.exception.ValidaCampoException;
import br.com.fatec.apphotel.entrypoint.model.request.HospedeEntrypointModelRequest;

public class HospedeValidation extends ModelRequestValidation{

	private HospedeValidation() {
	}

	public void validate(HospedeEntrypointModelRequest hospedeEntrypointModelRequest) throws JsonProcessingException, ValidaCampoException {
		
		super.validarCamposObrigatorio(hospedeEntrypointModelRequest);

	}
}
