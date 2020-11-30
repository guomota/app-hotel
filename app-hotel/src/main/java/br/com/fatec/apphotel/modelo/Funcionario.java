package br.com.fatec.apphotel.modelo;

import br.com.fatec.apphotel.objeto.PermissaoEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private PermissaoEnum permissao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public PermissaoEnum getPermissao() {
        return permissao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPermissao(PermissaoEnum permissao) {
        this.permissao = permissao;
    }

}
