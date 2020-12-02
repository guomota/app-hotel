package br.com.fatec.apphotel.controller.mapper;

import br.com.fatec.apphotel.controller.request.ReservaEntrypointRequest;
import br.com.fatec.apphotel.modelo.Reserva;

public class ReservaMapper {
	
	private ReservaMapper() {
	}

	public static Reserva toDomain(ReservaEntrypointRequest reservaEntrypointRequest) {

		Reserva reservaDomain = new Reserva();
		reservaDomain.setCodigoSuite(reservaEntrypointRequest.getCodigoSuite());
		reservaDomain.setCpf(reservaEntrypointRequest.getCpf());
		reservaDomain.setDataEntrada(reservaEntrypointRequest.getDataEntrada());
		reservaDomain.setDataSaida(reservaEntrypointRequest.getDataSaida());
		
		return reservaDomain;
	}

}
