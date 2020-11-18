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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.apphotel.controller.dto.HospedeDTO;
import br.com.fatec.apphotel.controller.mapper.HospedeMapper;
import br.com.fatec.apphotel.controller.request.HospedeEntrypointRequest;
import br.com.fatec.apphotel.modelo.Hospede;
import br.com.fatec.apphotel.repository.HospedeRepository;

/**
 * Classe reesponsável por conter os endpoints referente ao hospede
 * 
 * @author Gustavo Mota
 * @since 17/11/2020
 */
@RestController
@RequestMapping("/hospedes")
public class HospedeController {

	@Autowired
	private HospedeRepository hospedeRepository;

	/**
	 * Método responsável por cadastrar um hospede no banco de dados
	 * 
	 * @param {@code HospedeEntrypointRequest}
	 * @param {@code UriComponentsBuilder}
	 * 
	 * @return {@code ResponseEntity<HospedeDTO>}
	 */
	@PostMapping
	public ResponseEntity<HospedeDTO> cadastrarHospede(@RequestBody @Valid HospedeEntrypointRequest hospedeRequest,
			UriComponentsBuilder uriBuilder) {

		Hospede hospede = HospedeMapper.toDomain(hospedeRequest);
		hospedeRepository.save(hospede);

		URI uri = uriBuilder.path("/hospedes/{id}").buildAndExpand(hospede.getId()).toUri();
		return ResponseEntity.created(uri).body(new HospedeDTO(hospede));
	}

	/**
	 * Método responsável por listar todos os hospedes cadastrados no banco de dados
	 * 
	 * @return {@code List<HospedeDTO>}
	 */
	@GetMapping
	public List<HospedeDTO> listarHospedes() {
		
		List<Hospede> hospedes = hospedeRepository.findAll();

		return HospedeDTO.converter(hospedes);
	}

	/**
	 * Método responsável por buscar um hospede cadastrado no banco de dados 
	 * 
	 * @param {@code Long}
	 * 
	 * @return {@code ResponseEntity<HospedeDTO>}
	 */
	@GetMapping("/{cpf}")
	public ResponseEntity<HospedeDTO> detalharHospede(@PathVariable String cpf) {
		
		Optional<Hospede> hospede = hospedeRepository.findByCpf(cpf);
		if (hospede.isPresent()) {
			return ResponseEntity.ok(new HospedeDTO(hospede.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * Método responsável por atualizar as informações de um hospede cadastrado no banco de dados 
	 * 
	 * @param {@code Long}
	 * 
	 * @return {@code ResponseEntity<HospedeDTO>}
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<HospedeDTO> atualizar(@PathVariable Long id, @RequestBody @Valid HospedeEntrypointRequest hospedeRequest) {
		
		Optional<Hospede> optional = hospedeRepository.findById(id);
		if (optional.isPresent()) {
			Hospede topico = hospedeRequest.atualizar(id, hospedeRepository);
			return ResponseEntity.ok(new HospedeDTO(topico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * Método responsável por realizar a deleção de um hospede cadastrado no banco de dados 
	 * 
	 * @param {@code Long}
	 * 
	 * @return {@code ResponseEntity<?>}
	 */
	@DeleteMapping("/{cpf}")
	@Transactional
	public ResponseEntity<?> deletarHospede(@PathVariable String cpf) {
		
		Optional<Hospede> hospede = hospedeRepository.findByCpf(cpf);
		if (hospede.isPresent()) {
			hospedeRepository.deleteById(hospede.get().getId());
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
