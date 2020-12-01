package br.com.fatec.apphotel.controller.dto;

import br.com.fatec.apphotel.modelo.Servico;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoDTO {
    private Long codigo;
    private String descricao;
    private BigDecimal valor;

    public  ServicoDTO (Servico servico){
        super();
        this.codigo = servico.getCodigo ();
        this.descricao = servico.getDescricao ();
        this.valor = servico.getValor ();

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

    public static List<ServicoDTO> converter ( List<Servico> servicos ) {
        return servicos.stream ( ).map ( ServicoDTO::new ).collect ( Collectors.toList ( ) );
    }
}