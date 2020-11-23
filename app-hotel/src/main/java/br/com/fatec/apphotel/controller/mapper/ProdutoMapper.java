package br.com.fatec.apphotel.controller.mapper;

import br.com.fatec.apphotel.modelo.Produto;
import br.com.fatec.apphotel.controller.request.ProdutoEntrypointRequest;

public class ProdutoMapper {

    private ProdutoMapper () {
    }

    public static Produto toDomain ( ProdutoEntrypointRequest produtoEntrypointModelRequest ) {

        Produto produtoDomain = new Produto ( );
        produtoDomain.setDescricao ( produtoEntrypointModelRequest.getDescricao ( ) );
        produtoDomain.setValor ( produtoEntrypointModelRequest.getValor ( ) );

        return produtoDomain;
    }
}

