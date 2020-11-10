package br.com.fatec.apphotel.entrypoint.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fatec.apphotel.entrypoint.controller.exception.ParametroInvalidoException;
import br.com.fatec.apphotel.entrypoint.controller.exception.model.response.ParametroInvalidoModelResponse;
import br.com.fatec.apphotel.entrypoint.controller.exception.model.response.RequisicaoInvalidaModelResponse;

@Component
public class ModelRequestValidation {
	
	private <T> Set<ConstraintViolation<T>> validarConstraint(T request) {
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		return validator.validate(request);

	}
	
	public <T> void validarCamposObrigatorio(T request) throws ParametroInvalidoException, JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Set<ConstraintViolation<T>> constraints = (this.<T>validarConstraint(request));
		
		List<ParametroInvalidoModelResponse> campos = new ArrayList<>();	
		
		for(ConstraintViolation<T> constraint : constraints) {
			campos.add(new ParametroInvalidoModelResponse(constraint.getPropertyPath().toString(), constraint.getMessage()));
			
		}
		
		if(!campos.isEmpty()) {
			
			RequisicaoInvalidaModelResponse requisicaoInvalidaModelResponse = new RequisicaoInvalidaModelResponse();
			requisicaoInvalidaModelResponse.setCampos(campos);
			
			throw new ParametroInvalidoException(objectMapper.writeValueAsString(requisicaoInvalidaModelResponse));
			
		}
	}
}
