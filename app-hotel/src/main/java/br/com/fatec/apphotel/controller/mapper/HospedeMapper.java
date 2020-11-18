package br.com.fatec.apphotel.controller.mapper;

import br.com.fatec.apphotel.controller.request.HospedeEntrypointRequest;
import br.com.fatec.apphotel.modelo.Hospede;

public class HospedeMapper {

	private HospedeMapper() {
	}

	public static Hospede toDomain(HospedeEntrypointRequest hospedeEntrypointModelRequest) {

		Hospede hospedeDomain = new Hospede();
		hospedeDomain.setBairro(hospedeEntrypointModelRequest.getBairro());
		hospedeDomain.setCep(hospedeEntrypointModelRequest.getCep());
		hospedeDomain.setCidade(hospedeEntrypointModelRequest.getCidade());
		hospedeDomain.setComplemento(hospedeEntrypointModelRequest.getComplemento());
		hospedeDomain.setCpf(hospedeEntrypointModelRequest.getCpf());
		hospedeDomain.setEmail(hospedeEntrypointModelRequest.getEmail());
		hospedeDomain.setLogradouro(hospedeEntrypointModelRequest.getLogradouro());
		hospedeDomain.setNome(hospedeEntrypointModelRequest.getNome());
		hospedeDomain.setNumero(hospedeEntrypointModelRequest.getNumero());
		hospedeDomain.setTelefone(hospedeEntrypointModelRequest.getTelefone());
		hospedeDomain.setUf(hospedeEntrypointModelRequest.getUf());

		return hospedeDomain;
	}
}
