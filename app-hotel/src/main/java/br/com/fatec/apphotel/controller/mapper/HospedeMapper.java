package br.com.fatec.apphotel.controller.mapper;

import br.com.fatec.apphotel.controller.request.HospedeEntrypointRequest;
import br.com.fatec.apphotel.modelo.Hospede;

public class HospedeMapper {

	private HospedeMapper() {
	}

	public static Hospede toDomain(HospedeEntrypointRequest hospedeEntrypointModelRequest) {

		Hospede hospedeDomain = new Hospede();
		hospedeDomain.setCpf(hospedeEntrypointModelRequest.getCpf());
		hospedeDomain.setRg(hospedeEntrypointModelRequest.getRg());
		hospedeDomain.setEmail(hospedeEntrypointModelRequest.getEmail());
		hospedeDomain.setNome(hospedeEntrypointModelRequest.getNome());
		hospedeDomain.setTelefone(hospedeEntrypointModelRequest.getTelefone());

		return hospedeDomain;
	}
}
