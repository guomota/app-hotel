package br.com.fatec.apphotel.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.apphotel.controller.dto.HospedeDTO;
import br.com.fatec.apphotel.controller.mapper.HospedeMapper;
import br.com.fatec.apphotel.controller.request.HospedeEntrypointRequest;
import br.com.fatec.apphotel.modelo.Hospede;
import br.com.fatec.apphotel.repository.HospedeRepository;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

	@Autowired
	private HospedeRepository hospedeRepository;

	@PostMapping
	public ResponseEntity<HospedeDTO> cadastrarHospede(@RequestBody @Valid HospedeEntrypointRequest hospedeRequest,
			UriComponentsBuilder uriBuilder) {

		Hospede hospede = HospedeMapper.toDomain(hospedeRequest);
		hospedeRepository.save(hospede);

		URI uri = uriBuilder.path("/hospedes/{id}").buildAndExpand(hospede.getId()).toUri();
		return ResponseEntity.created(uri).body(new HospedeDTO(hospede));

	}

	@GetMapping
	public List<HospedeDTO> lista() {
		
		List<Hospede> hospedes = hospedeRepository.findAll();

		return HospedeDTO.converter(hospedes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<HospedeDTO> detalharHospede(@PathVariable Long id) {
		
		Optional<Hospede> hospede = hospedeRepository.findById(id);
		if (hospede.isPresent()) {
			return ResponseEntity.ok(new HospedeDTO(hospede.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarHospede(@PathVariable Long id) {
		
		Optional<Hospede> hospede = hospedeRepository.findById(id);
		if (hospede.isPresent()) {
			hospedeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
