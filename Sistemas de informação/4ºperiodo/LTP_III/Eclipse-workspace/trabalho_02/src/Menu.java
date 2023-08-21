import java.util.Scanner;

public class Menu {

	// Retornar os menus de opções para o cliente escolher o Produto a ser calculado

	public static int menuProduto(Produto[] produtos) {

		int op = 0,i = 1;
		// pq alerta a variavel sc?
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("**Menu Produtos**\n");
			System.out.println("Escolha um produto para obeter seu preço final");
			
			for (Produto produto : produtos) {
				
			    System.out.println(i +"-"+produto.formatarProdutoMenu());
			    i++;
			}
			
			
			op = scanner.nextInt();
		}

		clearConsole.limpaConsole();

		return op;
	}

	// Retornar os menus de opções da quantidade de impostos a serem incididos no produto
	//para dia 21/08 entender como fazer isso funfar

	public static int menuQuantidadeDeImpostos() {

		int op = 0;

		try (// pq alerta a variavel sc?
		Scanner scanner = new Scanner(System.in)) {
			System.out.println("**Menu Impostos**\n");
			System.out.println("Escolha a quantidade de impostos a serem aplicados no produto");
			System.out.println("1 - 1 imposto");
			System.out.println("2 - 2 impostos");
			System.out.println("3 - 3 impostos");
			System.out.println("4 - 4 impostos");
			
			op = scanner.nextInt();
		}

		clearConsole.limpaConsole();

		return op;
	}
	
	
	// Retornar os menus de opções para o cliente escolher os impostos a serem
	// calculados sobre o Produto
	
	//para dia 21/08 implementar nesse menu a att do menu de produtos
	
	public static int menuImpostos() {

		int op = 0;
		
		try (// pq alerta a variavel sc?
		Scanner scanner = new Scanner(System.in)) {
			System.out.println("**Menu Impostos**\n");
			System.out.println("Escolha os impostos a serem incididos no preço do produto");
			System.out.println("1 - ICMS: 7%");
			System.out.println("2 - Confins: 12%");
			System.out.println("3 - IPI: 8%");
			System.out.println("4 - ISS: 5%");
			System.out.println("5 - Cide: 10%");
			System.out.println("6 - CSLL: 4%");
			
			op = scanner.nextInt();
		}

		clearConsole.limpaConsole();

		return op;
	}
	

	

}
