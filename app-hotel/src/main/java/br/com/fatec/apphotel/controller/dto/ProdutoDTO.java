package br.com.fatec.apphotel.controller.dto;

import br.com.fatec.apphotel.modelo.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {

	private String descricao;
	private BigDecimal valor;


	public ProdutoDTO ( Produto produto) {
		super();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();
	}
	
	public String getDescricao() {
		return descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}

	
	public static List<ProdutoDTO> converter( List<Produto> produtos) {
		return produtos.stream().map( ProdutoDTO::new).collect(Collectors.toList());
	}
}
