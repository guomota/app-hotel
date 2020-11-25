package br.com.fatec.apphotel.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Suite {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private Double valorDiaria;
	private String disponivel;
	
	public Long getId() {
		return id;
	}
	public String getTipo() {
		return tipo;
	}
	public Double getValorDiaria() {
		return valorDiaria;
	}
	public String getDisponivel() {
		return disponivel;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
}
