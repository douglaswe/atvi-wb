package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.DezMaisConsumiram;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListagemGenero;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.MaisConsumidoGenero;
import com.wb.negocio.MaisConsumiramValor;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("Que tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Listar todos os clientes");
			System.out.println("3 - Cadastrar servico");
			System.out.println("4 - Cadastrar produto");
			System.out.println("5 - Todos cliente por genero");
			System.out.println("6 - Serviços ou produtos mais consumidos por genero");
			System.out.println("7 - 10 clientes que mais consumiram serviços ou produtos em quantidade");
			System.out.println("8 - 10 clientes que menos consumiram serviços ou produtos em quantidade");
			System.out.println("9 - 5 clientes que mais gastaram em serviços ou produtos");
			
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Até mais!\n");
				break;
			case 1:
				Cadastro cadastro = new CadastroCliente(empresa.getClientes());
				cadastro.cadastrar();
				break;
			case 2:
				Listagem listagem = new ListarTodosClientes(empresa.getClientes());
				listagem.listar();
				break;
			case 3:
				Cadastro appServico = new AppServico(empresa);
				appServico.cadastrar();
				break;		
			case 4:
				Cadastro appProduto = new AppProduto(empresa);
				appProduto.cadastrar();
				break;
			
			case 5:
				if (empresa.getClientes().size() == 0) {
					System.out.println("Não há clientes cadastrados!");
					break;
				}
				Listagem listarClienteGênero = new ListagemGenero(empresa.getClientes());
				listarClienteGênero.listar();
				break;
			
			
			case 6:
				if (empresa.getProdutos().size() == 0 && empresa.getServicos().size() == 0) {
					System.out.println("Não há produtos e serviços cadastrados!");
					break;
				}
				Listagem listarMaisConsumidoGenero = new MaisConsumidoGenero(empresa);
				listarMaisConsumidoGenero.listar();
				break;
			case 7:
				if (empresa.getClientes().size() == 0) {
					System.out.println("Não há clientes cadastrados!");
					break;
				}
				Listagem listarDezMaisConsumiram = new DezMaisConsumiram(empresa, "mais");
				listarDezMaisConsumiram.listar();
				break;
			case 8:
				if (empresa.getClientes().size() == 0) {
					System.out.println("Não há clientes cadastrados!");
					break;
				}
				Listagem listarDezMenosConsumiram = new DezMaisConsumiram(empresa, "menos");
				listarDezMenosConsumiram.listar();
				break;
			case 9:
				if (empresa.getClientes().size() == 0) {
					System.out.println("Não há clientes cadastrados!");
					break;
				}
				MaisConsumiramValor listarMaisConsumiramValor = new MaisConsumiramValor(empresa);
				listarMaisConsumiramValor.listar();
				break;
				
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}