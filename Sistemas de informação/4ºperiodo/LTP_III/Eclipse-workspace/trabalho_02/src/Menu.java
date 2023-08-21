import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	
	
	public static int menuPrincipal() {
		
		int op;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("**Menu Principal**\n");
		System.out.println("1- Listar Produtos e Impostos");
		System.out.println("2- Adicionar Produto");
		System.out.println("3- Adicionar Imposto");
		System.out.println("4- Editar Produto");		
		System.out.println("5- Editar Imposto");
		System.out.println("6- Comprar Produtos");
		System.out.println("7- Excluir Produto da lista de compras");
		System.out.println("8- Finalizar Compra");
		System.out.println("0- Sair");
		
		op = scanner.nextInt();
		
		return op;
	}
	
	public static int menuProduto(ArrayList<Produto> produtos) {
		int op = 0,i = 1;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("**Menu Produtos**\n");
		System.out.println("Escolha um produto para adicionar ao carrinho");
			
		for (Produto produto : produtos) {	
		   System.out.println(i +"-"+produto.formatarProdutoMenu());
		   i++;
		}
			
			
		op = scanner.nextInt();

		return op;
	}

	
	public static int menuImpostos(ArrayList<Imposto> impostos) {

		int op = 0,i = 1;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("**Menu Impostos**\n");
		System.out.println("Escolha os impostos a serem incididos no preço do produto");
		for (Imposto imposto : impostos) {	
			   System.out.println(i +"-"+imposto.formatarImposto());
			   i++;
			}
		
			
		op = scanner.nextInt();
		

		clearConsole.limpaConsole();

		return op;
	}
	
	//Menus de Listagem
	
	public static void menuProdutoListar(ArrayList<Produto> produtos) {
		int i = 1;
		
		System.out.println("**Produtos**");
		for (Produto produto : produtos) {	
		   //System.out.println(i +"-"+produto.formatarProdutoMenu());
			
		   //teste
		   System.out.println(i +"-"+produto.formatarProduto());
		   
		   i++;
		}
		System.out.println("\n");
	}

	public static void menuImpostosListar(ArrayList<Imposto> impostos) {

		int i = 1;
		
		System.out.println("**Impostos**");		
		for (Imposto imposto : impostos) {	
			   System.out.println(i +"-"+imposto.formatarImposto());
			   i++;
			}
		System.out.println("\n");
	}

	//Menu Insere Imposto no Produto
	
	public static Imposto menuImpostosInserirProduto(ArrayList<Imposto> impostos) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
				
		for (Imposto imposto : impostos) {	
			   System.out.println(i +"-"+imposto.formatarImposto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		return impostos.get(op);
	}
	
	//Menu atualiza Produto
	
	public static ArrayList<Produto> menuAtualizaProduto(ArrayList<Produto> produtos,ArrayList<Imposto> impostos) {
		
		int produtoIndex = menuAttProdutoAux(produtos);
		
		Produto produtoAtualizando = produtos.get(produtoIndex);
		
		produtos.set(produtoIndex, Produto.atualizaProdutos(produtoAtualizando, impostos));
		
		return produtos;
	}
	
	public static int menuAttProdutoAux(ArrayList<Produto> produtos) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
		
		System.out.println("Escolha um produto para modificar: ");
		
		for (Produto produto : produtos) {	
			   System.out.println(i +"-"+produto.formatarProduto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		
		return op;
	}
	
	//Menu atualiza Imposto
	

}
