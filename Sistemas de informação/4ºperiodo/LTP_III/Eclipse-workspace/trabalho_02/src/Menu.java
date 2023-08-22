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
		System.out.println("6- Escolher Produtos para Comprar");
		System.out.println("7- Listar de Compras");
		System.out.println("8- Excluir Produto da lista de Compras");
		System.out.println("9- Finalizar e ver os preços de venda");
		System.out.println("0- Sair");
		
		op = scanner.nextInt();
		
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

	public static void menuCompraListar(ArrayList<Produto> produtosEmCompra) {

		int i = 1;
		
		System.out.println("**Produtos no Carrinho de Compra**");
		for (Produto produto : produtosEmCompra) {	
		   //System.out.println(i +"-"+produto.formatarProdutoMenu());
			
		   //teste
		   System.out.println(i +"-"+produto.formatarProduto());
		   
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
		
		Produto produtoAtualizado = produtos.get(produtoIndex);
		
		produtos.set(produtoIndex, Produto.atualizaProdutos(produtoAtualizado, impostos));
		
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
	
	public static ArrayList<Imposto> menuAtualizaImposto(ArrayList<Imposto> impostos){
		
		int impostoIndex = menuAtualizaImpostoAux(impostos);
		
		Imposto ImpostoAtualizado = impostos.get(impostoIndex);
		
		impostos.set(impostoIndex, Imposto.atualizaImposto(ImpostoAtualizado));
		
		return impostos;
	}
	
	public static int menuAtualizaImpostoAux(ArrayList<Imposto> impostos) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
		
		System.out.println("Escolha um imposto para modificar: ");
		
		for (Imposto imposto : impostos) {	
			   System.out.println(i +"-"+imposto.formatarImposto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		return op;
	}

	//Menu Seleciona Produtos para vender
	
	public static ArrayList<Produto> menuSeleciona(ArrayList<Produto> produtos, ArrayList<Produto> produtodoVenda){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		
		int op =1;
		
		do {
			
			Produto produtoAuxiliar = menuSelecionaProdutoAux(produtos);
			
			produtodoVenda.add( produtoAuxiliar);
			
			System.out.println("Parar - 0 | Continuar - 1");
			op = scanner.nextInt();	
			
		} while (op != 0);
		
		return produtodoVenda;
	}
	
	public static Produto menuSelecionaProdutoAux(ArrayList<Produto> produtos) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
		
		System.out.println("Escolha um produto para inserir no carrinho: ");
		
		for (Produto produto : produtos) {	
			   System.out.println(i +"-"+produto.formatarProduto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		
		return produtos.get(op);
	}
	
	//Menu Exclusao de Produtos
	
	public static ArrayList<Produto> menuExcluirVendas(ArrayList<Produto> produtodoVenda){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		
		int op =1;
		
		do {
			
			Produto produtoAuxiliar = menuExcluirVendaProdutoAux(produtodoVenda);
			
			produtodoVenda.remove(produtoAuxiliar);
			
			System.out.println("Parar - 0 | Continuar - 1");
			op = scanner.nextInt();	
			
		} while (op != 0);
		
		return produtodoVenda;
	}
	public static Produto menuExcluirVendaProdutoAux(ArrayList<Produto> produtos) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
		
		System.out.println("Escolha um produto para Excluir da lista de Compras: ");
		
		for (Produto produto : produtos) {	
			   System.out.println(i +"-"+produto.formatarProduto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		
		return produtos.get(op);
	}
	
	//Menu Concluir 
	public static void menuConcluirVenda(ArrayList<Produto> produtodoVenda){
		
		
		System.out.println("Venda Concluída!\n");

	    for (Produto produto : produtodoVenda) {
	        double precoFinal = produto.calculaPrecoFinal(produto.getMargemLucro(), produto.getPrecoCusto(), produto);
	        produto.setPrecoVenda(precoFinal);
	        System.out.println(produto.formatarProdutoUltimaListagem());
	        System.out.println("-------------------------");
	    }

	    double totalVenda = 0.0;
	    for (Produto produto : produtodoVenda) {
	        totalVenda += produto.getPrecoVenda();
	    }

	    System.out.println("Total da Venda: R$" + totalVenda);
		
		
		
	}
	
}
