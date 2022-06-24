package com.wb.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa; 

public class DezMaisConsumiram extends Listagem {
	private Empresa empresa;
	private String maisOuMenos;
	private Entrada entrada;

	public DezMaisConsumiram(Empresa empresa, String maisOuMenos) {
		this.empresa = empresa;
		this.maisOuMenos = maisOuMenos;
		this.entrada = new Entrada();
	}
	
	@Override
	public void listar() {
		int consumidoNum = 0;
		boolean execucaoConsumido = true;
		while(execucaoConsumido) {
			System.out.println("Deseja mostrar os 10 clientes que " + maisOuMenos + " consumiram, em quantidade, serviços ou produtos?");
			System.out.println("1 - Serviços");
			System.out.println("2 - Produtos");
			consumidoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (consumidoNum == 1 || consumidoNum == 2) {
				execucaoConsumido = false;
			}
			else {
				System.out.println("Valor inválido! ");
			}
		}
		
		String consumido = "";
		List <MaisClienteConsumo> quantidadeTodosClientes = new ArrayList<>();
		for (Cliente cliente : empresa.getClientes()) {
			if (consumidoNum == 1) {
				consumido = "serviços";
				int quantidadeServicos = cliente.getServicosConsumidos().size();
				MaisClienteConsumo MaisClienteConsumo = new MaisClienteConsumo(cliente, quantidadeServicos);
				quantidadeTodosClientes.add(MaisClienteConsumo);
			} else {
				consumido = "produtos";
				int quantidadeProdutos = cliente.getProdutosConsumidos().size();
				MaisClienteConsumo MaisClienteConsumo = new MaisClienteConsumo(cliente, quantidadeProdutos);
				quantidadeTodosClientes.add(MaisClienteConsumo);
			}
		}
			
		if (maisOuMenos.equals("mais")) {
			Collections.sort(quantidadeTodosClientes, new Comparator<MaisClienteConsumo>() {
				  @Override
				  public int compare(MaisClienteConsumo qc1, MaisClienteConsumo qc2) {
				    return qc2.getQuantidadeConsumido().compareTo(qc1.getQuantidadeConsumido());
				  }
				});
		} else {
			Collections.sort(quantidadeTodosClientes, new Comparator<MaisClienteConsumo>() {
				  @Override
				  public int compare(MaisClienteConsumo qc1, MaisClienteConsumo qc2) {
				    return qc1.getQuantidadeConsumido().compareTo(qc2.getQuantidadeConsumido());
				  }
				});
		}
			
		int cont = 1;
		System.out.println("Lista dos 10 clientes que " + maisOuMenos + " consumiram " + consumido);
		System.out.println("--------------------------------------");
		for (MaisClienteConsumo MaisClienteConsumo : quantidadeTodosClientes) {
			if (cont > 10) {
				break;
			}
			System.out.println(cont + ")");
			System.out.println("Nome: " + MaisClienteConsumo.cliente.nome);
			System.out.println("CPF: " + MaisClienteConsumo.cliente.getCpf().getValor());
			System.out.println("Quantidade de " + consumido +  " consumidos: " + MaisClienteConsumo.getQuantidadeConsumido());
			System.out.println("--------------------------------------");
			cont++;			
		}	
	}
}
