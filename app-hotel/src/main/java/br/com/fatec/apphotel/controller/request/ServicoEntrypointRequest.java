package br.com.fatec.apphotel.controller.request;

import br.com.fatec.apphotel.modelo.Servico;
import br.com.fatec.apphotel.repository.ServicoRepository;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ServicoEntrypointRequest {
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

    public Servico atualizar ( Long codigo , ServicoRepository servicoRepository ) {
        Servico servico = servicoRepository.getOne ( codigo );

        servico.setDescricao ( this.descricao );
        servico.setValor ( this.valor );

        return servico;
    }

}
