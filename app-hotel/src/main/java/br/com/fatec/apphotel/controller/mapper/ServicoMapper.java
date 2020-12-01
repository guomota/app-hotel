package br.com.fatec.apphotel.controller.mapper;

import br.com.fatec.apphotel.modelo.Servico;
import br.com.fatec.apphotel.controller.request.ServicoEntrypointRequest;

public class ServicoMapper {

    private ServicoMapper () {
    }

    public static Servico toDomain ( ServicoEntrypointRequest servicoEntrypointModelRequest ) {

        Servico servicoDomain = new Servico ( );
        servicoDomain.setDescricao ( servicoEntrypointModelRequest.getDescricao ( ) );
        servicoDomain.setValor ( servicoEntrypointModelRequest.getValor ( ) );

        return servicoDomain;
    }
}