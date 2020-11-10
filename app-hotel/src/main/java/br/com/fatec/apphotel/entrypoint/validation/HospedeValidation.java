package br.com.fatec.apphotel.entrypoint.validation;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;


import br.com.fatec.apphotel.entrypoint.model.request.HospedeEntrypointModelRequest;

@Component
public class HospedeValidation extends ModelRequestValidation{

	private HospedeValidation() {
	}

	public void validate(HospedeEntrypointModelRequest hospedeEntrypointModelRequest) throws JsonProcessingException {
		
		super.validarCamposObrigatorio(hospedeEntrypointModelRequest);

	}
}
