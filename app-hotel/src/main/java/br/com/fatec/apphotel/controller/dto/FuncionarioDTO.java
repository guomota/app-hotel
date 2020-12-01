package br.com.fatec.apphotel.controller.dto;

import br.com.fatec.apphotel.modelo.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String usuario;
    private String permissao;

    public FuncionarioDTO ( Funcionario funcionario ) {
        super ( );
        this.id = funcionario.getId ( );
        this.nome = funcionario.getNome ( );
        this.usuario = funcionario.getUsuario ( );
        this.permissao = funcionario.getPermissao ( );
    }

    public Long getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    public String getUsuario () {
        return usuario;
    }

    public String getPermissao () {
        return permissao;
    }

    public static List<FuncionarioDTO> converter ( List<Funcionario> suites ) {
        return suites.stream ( ).map ( FuncionarioDTO::new ).collect ( Collectors.toList ( ) );
    }
}
