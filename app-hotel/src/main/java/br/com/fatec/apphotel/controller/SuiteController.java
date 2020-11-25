package br.com.fatec.apphotel.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.apphotel.controller.dto.SuiteDTO;
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
	public ResponseEntity<SuiteDTO> cadastrarSuite(@RequestBody @Valid SuiteEntrypointRequest suiteRequest,
			UriComponentsBuilder uriBuilder) {

		Suite suite = SuiteMapper.toDomain(suiteRequest);
		suiteRepository.save(suite);

		URI uri = uriBuilder.path("/suites/{id}").buildAndExpand(suite.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new SuiteDTO(suite));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SuiteDTO> detalharHospede(@PathVariable Long id) {
		
		Optional<Suite> suite = suiteRepository.findById(id);
		if (suite.isPresent()) {
			return ResponseEntity.ok(new SuiteDTO(suite.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

}
