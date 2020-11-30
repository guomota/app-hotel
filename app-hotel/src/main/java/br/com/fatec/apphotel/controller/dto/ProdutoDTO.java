package br.com.fatec.apphotel.controller.dto;

import br.com.fatec.apphotel.modelo.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {
    private Long codigo;
    private String descricao;
    private BigDecimal valor;

    public  ProdutoDTO (Produto produto){
        super();
        this.codigo = produto.getCodigo ();
        this.descricao = produto.getDescricao ();
        this.valor = produto.getValor ();

    }

    public Long getCodigo () {
        return codigo;
    }

    public void setCodigo ( Long codigo ) {
        this.codigo = codigo;
    }

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

    public static List<ProdutoDTO> converter ( List<Produto> produtos ) {
        return produtos.stream ( ).map ( ProdutoDTO::new ).collect ( Collectors.toList ( ) );
    }
}
