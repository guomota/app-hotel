package br.com.fatec.apphotel.controller.request;

import br.com.fatec.apphotel.modelo.Funcionario;
import br.com.fatec.apphotel.objeto.PermissaoEnum;
import br.com.fatec.apphotel.repository.FuncionarioRepository;

public class FuncionarioEntrypointRequest {

    private String nome;
    private String usuario;
    private String senha;
    private PermissaoEnum permissao;

    public String getNome () {
        return nome;
    }

    public String getUsuario () { return usuario; }

    public String getSenha () { return senha; }

    public PermissaoEnum getPermissao () { return permissao; }

    public void setNome ( String nome ) {
        this.nome = nome;
    }

    public void setUsuario ( String usuario ) {
        this.usuario = usuario;
    }

    public void setSenha ( String senha ) {
        this.senha = senha;
    }

    public void setPermissao ( PermissaoEnum permissao ) {
        this.permissao = permissao;
    }

    public Funcionario atualizarSenha ( Long id , FuncionarioRepository produtoRepository ) {
        Funcionario funcionario = produtoRepository.getOne ( id );

        funcionario.setSenha ( this.senha );

        return funcionario;
    }

    public Funcionario atualizarAdmin ( Long id , FuncionarioRepository produtoRepository ) {
        Funcionario funcionario = produtoRepository.getOne ( id );

        funcionario.setNome ( this.nome );
        funcionario.setUsuario ( this.usuario );
        funcionario.setPermissao ( this.permissao );

        return funcionario;
    }
}
