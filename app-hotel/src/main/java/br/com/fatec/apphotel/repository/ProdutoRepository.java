package br.com.fatec.apphotel.repository;

import br.com.fatec.apphotel.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Optional<Produto> findByCodigo ( Long codigo );
}
