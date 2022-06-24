package com.wb.negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Servico;
import com.wb.modelo.Telefone;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;
	private int tipo;
	
	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ListarTodosClientes(List<Cliente> clientes, int tipo) {
		this.clientes = clientes;
		this.tipo = tipo;
	}


	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
		for (Cliente cliente : clientes) {
			System.out.println("G�nero: " + cliente.genero);
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("CPF: " + cliente.getCpf().getValor()+ "\r\n" + "Data Emiss�o: " + cliente.getCpf().getDataEmissao());
			for(RG rg: cliente.getRgs()) {
			System.out.println("RG: " + rg.getValor()+"\r\n" + "Data Emiss�o: " + cliente.getCpf().getDataEmissao());
			}
			for(Telefone telefone: cliente.getTelefones()) {
				System.out.println("Telefone: " +"("+telefone.getDdd()+") " +telefone.getNumero());
				}
			
			if (tipo == 0) {
				System.out.println("Servi�o(s) Consumido(s): ");
				if (cliente.getServicosConsumidos().size() == 0) {
					System.out.println(" Este cliente n�o possui servi�os consumidos.");
				} else {
					Set<Servico> todosServicos = new HashSet<>();
					todosServicos.addAll(cliente.getServicosConsumidos());
					List<QuantidadeServico> quantidadeTodosServicos = new ArrayList<>();
					for (Servico servico : todosServicos) {
						int quantidade = 0;
						for (Servico servicoCliente : cliente.getServicosConsumidos()){
							if (servico.equals(servicoCliente)) {
								quantidade++;
							}
						}
						QuantidadeServico quantidadeServico = new QuantidadeServico(servico, quantidade);
						quantidadeTodosServicos.add(quantidadeServico);		
					}
					for (QuantidadeServico quantidadeServico : quantidadeTodosServicos) {
						System.out.println(" " + quantidadeServico.servico.nome + 
								" - Quantidade consumido: " +  quantidadeServico.getQuantidadeConsumido() +
								" - Valor do Produto: " + quantidadeServico.servico.valor);
					}
				}
				System.out.println("Produto(s) Consumido(s): ");
				if (cliente.getProdutosConsumidos().size() == 0) {
					System.out.println(" Este cliente n�o possui produtos consumidos.");
				} else {
					Set<Produto> todosProdutos = new HashSet<>();
					todosProdutos.addAll(cliente.getProdutosConsumidos());
					List<QuantidadeProduto> quantidadeTodosProdutos = new ArrayList<>();
					for (Produto produto : todosProdutos) {
						int quantidade = 0;
						for (Produto produtoCliente : cliente.getProdutosConsumidos()){
							if (produto.equals(produtoCliente)) {
								quantidade++;
							}
						}
						QuantidadeProduto quantidadeProduto = new QuantidadeProduto(produto, quantidade);
						quantidadeTodosProdutos.add(quantidadeProduto);		
					}
					for (QuantidadeProduto quantidadeProduto : quantidadeTodosProdutos) {
						System.out.println(" " + quantidadeProduto.produto.nome + 
								" - Quantidade consumido: " +  quantidadeProduto.getQuantidadeConsumido() +
								" - Valor do Produto: " + quantidadeProduto.produto.valor);
					}
				}
			}
			
			System.out.println("--------------------------------------");
		}
	}
}
