package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.Listagem;

public class AppProduto extends Cadastro {
	private Empresa empresa;
	private Entrada entrada;

	public AppProduto(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("Que tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Listar todos os produtos");
			
			System.out.println("0 - Voltar para tela inicial");
			
			int operacao = entrada.receberNumeroInteiro();
			
			switch(operacao) {
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial");
				break;
			case 1:
				Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
				cadastroProduto.cadastrar();
				break;
			case 2:
				if (empresa.getProdutos().size() == 0) {
					System.out.println("Não há produto cadastrados!");
					break;
				}
				Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos());
				listagemProdutos.listar();
				break;
		
			default:
				System.out.println("Operação não entendida");
			}
		}
	}

}
