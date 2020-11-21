package br.com.fatec.apphotel.controller;

import br.com.fatec.apphotel.controller.dto.ProdutoDTO;
import br.com.fatec.apphotel.controller.mapper.ProdutoMapper;
import br.com.fatec.apphotel.controller.request.ProdutoEntrypointRequest;
import br.com.fatec.apphotel.modelo.Produto;
import br.com.fatec.apphotel.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Classe reesponsável por conter os endpoints referente ao hospede
 * 
 * @author Kim Tsunida
 * @since 20/11/2020
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * Método responsável por cadastrar um Produto no banco de dados
	 * 
	 * @param {@code ProdutoEntrypointRequest}
	 * @param {@code UriComponentsBuilder}
	 * 
	 * @return {@code ResponseEntity<ProdutoDTO>}
	 */
	@PostMapping
	public ResponseEntity<ProdutoDTO> cadastrarProdutoe(@RequestBody @Valid ProdutoEntrypointRequest produtoRequest,
			UriComponentsBuilder uriBuilder) {

		Produto produto = ProdutoMapper.toDomain(produtoRequest);
		produtoRepository.save(produto);

		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
	}

	/**
	 * Método responsável por listar todos os Produtos cadastrados no banco de dados
	 * 
	 * @return {@code List<ProdutoDTO>}
	 */
	@GetMapping
	public List<ProdutoDTO> listarProduto() {
		
		List<Produto> produto = produtoRepository.findAll();

		return ProdutoDTO.converter(produto);
	}

	/**
	 * Método responsável por buscar um Produto cadastrado no banco de dados
	 * 
	 * @param {@code Long}
	 * 
	 * @return {@code ResponseEntity<HospedeDTO>}
	 */
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoDTO> detalharProduto(@PathVariable Long codigo) {
		
		Optional<Produto> hospede = produtoRepository.findByCodigo(codigo);
		if (hospede.isPresent()) {
			return ResponseEntity.ok(new ProdutoDTO(hospede.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * Método responsável por atualizar as informações de um Produto cadastrado no banco de dados
	 * 
	 * @param {@code Long}
	 * 
	 * @return {@code ResponseEntity<ProdutoDTO>}
	 */
	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long codigo, @RequestBody @Valid ProdutoEntrypointRequest produtoRequest) {
		
		Optional<Produto> optional = produtoRepository.findByCodigo(codigo);
		if (optional.isPresent()) {
			Produto topico = produtoRequest.atualizar(codigo, produtoRepository);
			return ResponseEntity.ok(new ProdutoDTO(topico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * Método responsável por realizar a deleção de um Produto cadastrado no banco de dados
	 * 
	 * @param {@code Long}
	 * 
	 * @return {@code ResponseEntity<?>}
	 */
	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> deletarProduto(@PathVariable Long codigo) {
		
		Optional<Produto> produto = produtoRepository.findByCodigo(codigo);
		if (produto.isPresent()) {
			produtoRepository.deleteById(produto.get().getCodigo());
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
