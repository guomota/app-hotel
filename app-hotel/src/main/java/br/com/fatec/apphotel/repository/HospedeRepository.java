package br.com.fatec.apphotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.apphotel.modelo.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {

}
