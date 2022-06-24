package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroServico;
import com.wb.negocio.Listagem;

public class AppServico extends Cadastro {
	private Empresa empresa;
	private Entrada entrada;

	public AppServico(Empresa empresa) {
		this.empresa = empresa;
		this.entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		boolean execucao = true;
		while (execucao) {
			System.out.println("Que tipo de opera��o voc� deseja fazer:");
			System.out.println("1 - Cadastrar servi�o");
			System.out.println("2 - Listar todos os servi�os");
			System.out.println("0 - Voltar para tela inicial");
			
			int operacao = entrada.receberNumeroInteiro();
			
			switch(operacao) {
			case 0:
				execucao = false;
				System.out.println("Voltando para tela inicial");
				break;
			case 1:
				Cadastro cadastroServico = new CadastroServico(empresa.getServicos());
				cadastroServico.cadastrar();
				break;
			case 2:
				if (empresa.getServicos().size() == 0) {
					System.out.println("N�o h� servi�os cadastrados!");
					break;
				}
				Listagem listagemServicos = new ListarServicos(empresa.getServicos());
				listagemServicos.listar();
				break;
			
			default:
				System.out.println("Opera��o n�o entendida");
			}
		}
	}
}
