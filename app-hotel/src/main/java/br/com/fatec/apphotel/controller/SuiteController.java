package br.com.fatec.apphotel.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.apphotel.controller.dto.HospedeDTO;
import br.com.fatec.apphotel.controller.mapper.SuiteMapper;
import br.com.fatec.apphotel.controller.request.SuiteEntrypointRequest;
import br.com.fatec.apphotel.modelo.Suite;
import br.com.fatec.apphotel.repository.SuiteRepository;

/**
 * Classe reesponsável por conter os endpoints referente as suítes
 * 
 * @author Gustavo Mota
 * @since 18/11/2020
 */
@RestController
@RequestMapping("/suites")
public class SuiteController {
	
	@Autowired
	private SuiteRepository suiteRepository;
	
	@PostMapping
	public ResponseEntity<HospedeDTO> cadastrarSuite(@RequestBody @Valid SuiteEntrypointRequest suiteRequest,
			UriComponentsBuilder uriBuilder) {

		Suite suite = SuiteMapper.toDomain(suiteRequest);
		suiteRepository.save(suite);

		URI uri = uriBuilder.path("/suites/{id}").buildAndExpand(suite.getId()).toUri();
		
		return null;
	}

}
