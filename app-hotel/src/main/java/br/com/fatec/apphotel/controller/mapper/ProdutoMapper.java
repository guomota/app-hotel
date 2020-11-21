package br.com.fatec.apphotel.controller.mapper;

import br.com.fatec.apphotel.controller.request.ProdutoEntrypointRequest;
import br.com.fatec.apphotel.modelo.Produto;

public class ProdutoMapper {

	private ProdutoMapper () {
	}

	public static Produto toDomain(ProdutoEntrypointRequest produtoEntrypointRequest) {

		Produto produtoDomain = new Produto();
		produtoDomain.setDescricao(produtoEntrypointRequest.getDescricao());
		produtoDomain.setValor(produtoEntrypointRequest.getValor());

		return produtoDomain;
	}
}
