package br.com.fatec.apphotel.controller.mapper;

import br.com.fatec.apphotel.controller.request.SuiteEntrypointRequest;
import br.com.fatec.apphotel.modelo.Suite;

public class SuiteMapper {

	private SuiteMapper() {}

	public static Suite toDomain(SuiteEntrypointRequest suiteEntrypointRequest) {
	
		Suite suite = new Suite();
		suite.setTipo(suiteEntrypointRequest.getTipo());
		suite.setValorDiaria(suiteEntrypointRequest.getValor());
		suite.setDisponivel(suiteEntrypointRequest.getStatus());
		
		return suite;

	}
}
