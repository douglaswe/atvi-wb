package com.wb;

import java.util.List;

import com.wb.modelo.Produto;
import com.wb.negocio.Listagem;

public class ListarTodosProdutos extends Listagem {
	
	private List<Produto> produtos;

	public ListarTodosProdutos(List<Produto> produtos) {
		this.produtos= produtos;
	}

		@Override
		public void listar() {
			System.out.println("Lista de todos os produtos:");
			System.out.println("---------------------------");
			for (Produto produto : produtos) {
				System.out.println("Nome: " + produto.nome);
				System.out.println("Valor: " + produto.valor);
				System.out.println("--------------------------------------");
			}

	}

}
