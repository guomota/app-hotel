package br.com.fatec.apphotel.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descricao;
    private BigDecimal valor;

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
}