package br.com.fatec.apphotel.controller.mapper;

import br.com.fatec.apphotel.controller.request.FuncionarioEntrypointRequest;
import br.com.fatec.apphotel.modelo.Funcionario;

public class FuncionarioMapper {

    private FuncionarioMapper() {
    }

    public static Funcionario toDomain( FuncionarioEntrypointRequest funcionarioEntrypointRequest ) {

        Funcionario funcionarioDomain = new Funcionario();
        funcionarioDomain.setNome ( funcionarioEntrypointRequest.getNome () );
        funcionarioDomain.setUsuario ( funcionarioEntrypointRequest.getUsuario ());
        funcionarioDomain.setSenha ( funcionarioEntrypointRequest.getSenha () );
        funcionarioDomain.setPermissao ( funcionarioEntrypointRequest.getPermissao () );


        return funcionarioDomain;
    }
}
