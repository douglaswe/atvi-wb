package com.wb.negocio;

import com.wb.modelo.Servico;

public class QuantidadeServico{
	public Servico servico;
	private Integer quantidadeConsumido;
	
	public QuantidadeServico(Servico servico, Integer quantidadeConsumido) {
		this.servico = servico;
		this.quantidadeConsumido = quantidadeConsumido;
	}

	public Integer getQuantidadeConsumido() {
		return quantidadeConsumido;
	}
	
	public void setQuantidadeConsumido(Integer quantidadeConsumido) {
		this.quantidadeConsumido = quantidadeConsumido;
	}	
}