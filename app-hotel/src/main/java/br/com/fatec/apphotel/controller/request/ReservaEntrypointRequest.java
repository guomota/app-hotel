package br.com.fatec.apphotel.controller.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.fatec.apphotel.modelo.Reserva;
import br.com.fatec.apphotel.repository.ReservaRepository;

public class ReservaEntrypointRequest {

	@NotBlank(message = "O campo codigoSuite é obrigatório")
	private String codigoSuite;

	@NotBlank(message = "O campo cpf é obrigatório")
	@Pattern(regexp = "[0-9]{11}$", message = "O campo cpf deve conter apenas números com 11 dígitos")
	private String cpf;

	private Date dataEntrada;

	private Date dataSaida;

	public String getCodigoSuite() {
		return codigoSuite;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setCodigoSuite(String codigoSuite) {
		this.codigoSuite = codigoSuite;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Reserva atualizar(Long id, ReservaRepository reservaRepository) {
		Reserva reserva = reservaRepository.getOne(id);

		reserva.setCodigoSuite(this.codigoSuite);
		reserva.setCpf(this.cpf);
		reserva.setDataEntrada(this.dataEntrada);
		reserva.setDataSaida(this.dataSaida);

		return reserva;
	}

}
