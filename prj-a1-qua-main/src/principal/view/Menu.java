package principal.view;

import principal.daos.*;
import principal.model.*;
import java.util.Scanner;

public class Menu {
	
	private Scanner leitor;
	
	public Menu() {
		this.leitor = new Scanner(System.in);
	}
	
	public void tela() {
		int opcao;
		Scanner leitor = new Scanner(System.in);
		System.out.println("Selecione a opçao");
		System.out.println("1. criar");
		System.out.println("2. listar");
		System.out.println("3. editar");
		System.out.println("4. apagar");
		System.out.println("5. saiar");
		opcao = leitor.nextInt();
		
		switch (opcao) {
			case 1:
				criaralgo();
				break;
			case 2:
				listaralgo();
				break;
			case 3:
				editaralgo();
				break;
			case 4:
				apagaralgo();
				break;
			case 5:
				leitor.close();
				break;
			default:
				break;
						}
		
	}


private void criaralgo() {
	PedidoDAO pedidoDAO = new PedidoDAO(); 
	
	String nome;
	int quantidade;
	System.out.println("Insira o nome do livro: ");
	this.leitor.nextLine();
	nome = this.leitor.nextLine();
	System.out.println("Insira quantos livros estarão disponiveis: ");
	quantidade = this.leitor.nextInt();
	Pedido pedido = new Pedido(nome, quantidade,0);
	pedidoDAO.salvar(pedido);
	
	pedidoDAO.close();
}

private void listaralgo() {
	PedidoDAO pedidoDAO = new PedidoDAO(); 
}

private void editaralgo() {
	PedidoDAO pedidoDAO = new PedidoDAO(); 
}

private void apagaralgo() {
	PedidoDAO pedidoDAO = new PedidoDAO(); 
}



}