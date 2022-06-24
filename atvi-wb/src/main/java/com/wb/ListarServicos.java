package com.wb;

import com.wb.negocio.Listagem;

import java.util.List;

import com.wb.modelo.Servico;

public class ListarServicos extends Listagem {
	private List<Servico> servicos;

	public ListarServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	@Override
	public void listar() {
		System.out.println("Lista de todos os serviços:");
		System.out.println("---------------------------");
		for (Servico servico : servicos) {
			System.out.println("Nome: " + servico.nome);
			System.out.println("Valor: " + servico.valor);
			System.out.println("--------------------------------------");

			
		}

	}
}