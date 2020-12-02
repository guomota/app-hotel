package br.com.fatec.apphotel.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fatec.apphotel.modelo.Reserva;

public class ReservaDTO {
	
	private Long id;
	private String cpf;
	private String codigoSuite;
	private Date dataEntrada;
	private Date dataSaida;
	
	public ReservaDTO(Reserva reserva) {
		super();
		this.id = reserva.getId();
		this.cpf = reserva.getCpf();
		this.codigoSuite = reserva.getCodigoSuite();
		this.dataEntrada = reserva.getDataEntrada();
		this.dataSaida = reserva.getDataSaida();
	}
	
	public Long getId() {
		return id;
	}
	public String getCpf() {
		return cpf;
	}
	public String getCodigoSuite() {
		return codigoSuite;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setCodigoSuite(String codigoSuite) {
		this.codigoSuite = codigoSuite;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public static List<ReservaDTO> converter(List<Reserva> reservas) {
		return reservas.stream().map(ReservaDTO::new).collect(Collectors.toList());
	}
}
