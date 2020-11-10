package br.com.fatec.apphotel.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.fatec.apphotel.entrypoint.mapper.domain.HospedeEntrypointDomainMapper;
import br.com.fatec.apphotel.entrypoint.model.request.HospedeEntrypointModelRequest;
import br.com.fatec.apphotel.entrypoint.validation.HospedeValidation;
import br.com.fatec.apphotel.usecase.domain.HospedeDomain;

@RestController
@RequestMapping(value = HospedeController.URI)
public class HospedeController {
	
	protected static final String URI = "/hospede";
	
	@Autowired
	private HospedeValidation hospedeValidation;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<HospedeEntrypointModelRequest> cadastrarHospede(
			@RequestBody(required = true) HospedeEntrypointModelRequest hospedeEntrypointModelRequest) throws JsonProcessingException {
				
		hospedeValidation.validate(hospedeEntrypointModelRequest);
		
		HospedeDomain hospedeDomain = HospedeEntrypointDomainMapper.toDomain(hospedeEntrypointModelRequest);
		
		return new ResponseEntity<>(hospedeEntrypointModelRequest, HttpStatus.CREATED);	
	}
}
