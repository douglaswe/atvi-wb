package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class CadastroServico extends Cadastro{
	private List<Servico> servicos;
	private Entrada entrada;

	public CadastroServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		
		System.out.println("Informe o nome do serviço:");
		String nome = entrada.receberTexto();
		
		System.out.println("Informe o valor do serviço:");
		double valor = entrada.receberNumeroDouble();
		entrada.receberTexto();
		
		Servico servico = new Servico(nome, valor);
		this.servicos.add(servico);
		System.out.println("Serviço cadastrado!");

	}
	
}