package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro do cliente");
		
		String genero = "";
		boolean execucaoGenero = true;
		while(execucaoGenero) {
			System.out.println("Por favor informe o genero do cliente:");
			System.out.println("1 - Masculino");
			System.out.println("2 - Feminino");
			int generoNum = entrada.receberNumeroInteiro();
			entrada.receberTexto();
			if (generoNum == 1) {
				genero = "Masculino";
				execucaoGenero = false;
			} else {
				if (generoNum == 2) {
					genero = "Feminino";
					execucaoGenero = false;
				}
				else {
					System.out.println("Operação não entendida.");
				}
			}
		}
		
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		
		System.out.println("Por favor informe o número do cpf:");
		String valor = entrada.receberTexto();
		
		System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
		String data = entrada.receberTexto();
		
		System.out.println("Por favor informe o número do RG:");
		String valorRg = entrada.receberTexto();
		
		System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
		String dataRg = entrada.receberTexto();
		
		System.out.println("Por favor informe o numero de ddd:");
		String ddd = entrada.receberTexto();
		
		System.out.println("Por favor informe o numero de telefone:");
		String numero = entrada.receberTexto();
		
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		
		LocalDate dataEmissaoRg = LocalDate.parse(dataRg, formato);
		
		CPF cpf = new CPF(dataEmissao, valor);
		
		RG rgs = new RG(dataEmissaoRg, valorRg);
		
		Telefone telefones = new Telefone(ddd,numero);
		
		
		Cliente cliente = new Cliente(nome, nomeSocial, cpf,genero);
		
		cliente.getRgs().add(rgs);
		
		
		cliente.getTelefones().add(telefones);
		
		this.clientes.add(cliente);
		System.out.println("Cliente cadastrado!");
		
	}  
}