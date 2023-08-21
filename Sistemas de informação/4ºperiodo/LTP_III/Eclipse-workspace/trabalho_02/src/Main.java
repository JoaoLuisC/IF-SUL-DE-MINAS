import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int opQuantidadeProduto;
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o numero de Produtos a serem inseridos: ");
		opQuantidadeProduto = scanner.nextInt();
		
		
		
		Produto[] produtos = new Produto[opQuantidadeProduto];
		
		produtos = Produto.insereProdutos(opQuantidadeProduto);
        
        
		@SuppressWarnings("unused")
		int opProduto = Menu.menuProduto(produtos);
		
		//implementar a leitura dos impostos do msm jeito do menu 

		
		
	}
	
	//para dia 21/08 Menu,Main, testar os metodos de conta , imaginar oq fazer com o clearConsole
	//perguntar pq o scanner fica amarelin pro ermerson
	
}
