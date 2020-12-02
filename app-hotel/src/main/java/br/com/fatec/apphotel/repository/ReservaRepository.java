package br.com.fatec.apphotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.apphotel.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}
