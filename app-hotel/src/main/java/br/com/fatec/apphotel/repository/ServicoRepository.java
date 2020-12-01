package br.com.fatec.apphotel.repository;

import br.com.fatec.apphotel.modelo.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    Optional<Servico> findByCodigo ( Long codigo );

}