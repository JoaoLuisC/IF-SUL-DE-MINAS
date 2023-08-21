import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings({ "resource", "unused" })
		Scanner scanner = new Scanner(System.in);
	
		ArrayList<Imposto> impostos = new ArrayList<>();
		impostos = SetupTeste.popularImpostos();
		
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos = SetupTeste.popularProdutos(impostos);

		
		
		int op = Menu.menuPrincipal();
		
		do {
			switch (op) {
				
				//Listar Produtos e Listas
				case 1: 
					Menu.menuProdutoListar(produtos);
					Menu.menuImpostosListar(impostos);
				break;
				
				case 2: 
					Produto.insereProdutos(produtos,impostos);	
				break;
				
				case 3: 
					Imposto.insereImposto(impostos);					
				break;
				
				case 4: 
					Menu.menuAtualizaProduto(produtos, impostos);
				break;
				
				case 5: 
					
					
				break;
				
				case 6: 
					
					
				break;
				
				case 7: 
					
					
				break;
				
				case 8: 
					
					
				break;
				
				
				case 0: 
					System.exit(0);
				break;
			
				default:
					throw new IllegalArgumentException("Unexpected value: " + op);
			}
			op = Menu.menuPrincipal();
		} while (op!=0);
		
		
	}
		
}

/*
  
		@SuppressWarnings("unused")
		int opQuantidadeProduto = 0;

		System.out.println("Digite o numero de Produtos a serem inseridos: ");
		opQuantidadeProduto = scanner.nextInt(); 
		
		@SuppressWarnings("unused")
		int opProduto = Menu.menuProduto(produtos);
*/
