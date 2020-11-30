package br.com.fatec.apphotel.repository;

import br.com.fatec.apphotel.modelo.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByNome( String nome)  ;
}
