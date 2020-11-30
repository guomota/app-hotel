package br.com.fatec.apphotel.controller.request;

import br.com.fatec.apphotel.modelo.Produto;
import br.com.fatec.apphotel.repository.ProdutoRepository;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ProdutoEntrypointRequest {
    @NotBlank(message = "O campo descricao é obrigátorio")
    private String descricao;

    private BigDecimal valor;

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao ( String descricao ) {
        this.descricao = descricao;
    }

    public BigDecimal getValor () {
        return valor;
    }

    public void setValor ( BigDecimal valor ) {
        this.valor = valor;
    }

    public Produto atualizar ( Long codigo , ProdutoRepository produtoRepository ) {
        Produto produto = produtoRepository.getOne ( codigo );

        produto.setDescricao ( this.descricao );
        produto.setValor ( this.valor );

        return produto;
    }

}