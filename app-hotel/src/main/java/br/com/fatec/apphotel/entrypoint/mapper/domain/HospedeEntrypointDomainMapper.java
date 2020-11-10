package br.com.fatec.apphotel.entrypoint.mapper.domain;

import br.com.fatec.apphotel.entrypoint.model.request.HospedeEntrypointModelRequest;
import br.com.fatec.apphotel.usecase.domain.HospedeDomain;

public class HospedeEntrypointDomainMapper {
	
	private HospedeEntrypointDomainMapper() {}
	
	public static HospedeDomain toDomain (HospedeEntrypointModelRequest hospedeEntrypointModelRequest) {
		
		HospedeDomain hospedeDomain = new HospedeDomain();
		hospedeDomain.setBairro(hospedeEntrypointModelRequest.getBairro());
		
		return HospedeDomain.builder()
				.bairro(hospedeEntrypointModelRequest.getBairro())
				.cep(hospedeEntrypointModelRequest.getCep())
				.cidade(hospedeEntrypointModelRequest.getCidade())
				.complemento(hospedeEntrypointModelRequest.getComplemento())
				.cpf(hospedeEntrypointModelRequest.getCep())
				.email(hospedeEntrypointModelRequest.getEmail())
				.logradouro(hospedeEntrypointModelRequest.getLogradouro())
				.nome(hospedeEntrypointModelRequest.getNome())
				.numero(hospedeEntrypointModelRequest.getNumero())
				.telefone(hospedeEntrypointModelRequest.getTelefone())
				.uf(hospedeEntrypointModelRequest.getUf())
				.build();	
	}
}
