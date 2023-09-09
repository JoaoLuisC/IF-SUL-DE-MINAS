package model.menus;
import java.util.ArrayList;
import java.util.Scanner;

import model.products.Products;
import model.products.calculations.ProductsCalcs;
import model.products.util.ProductsUtil;
import model.taxes.Taxes;
import model.taxes.util.TaxesUtil;

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
	
	public static void menuProdutoListar(ArrayList<Products> produtos) {
		int i = 1;
		//clearConsole();
		System.out.println("**Produtos**");
		for (Products produto : produtos) {	
		   //System.out.println(i +"-"+produto.formatarProdutoMenu());
			
		   //teste
		   System.out.println(i +"-"+produto.formatarProduto());
		   
		   i++;
		}
		System.out.println("\n");
	}

	public static void menuImpostosListar(ArrayList<Taxes> impostos) {

		int i = 1;
		
		System.out.println("**Impostos**");		
		for (Taxes imposto : impostos) {	
			   System.out.println(i +"-"+imposto.formatarImposto());
			   i++;
			}
		System.out.println("\n");
	}

	public static void menuCompraListar(ArrayList<Products> produtosEmCompra) {

		int i = 1;
		
		System.out.println("**Produtos no Carrinho de Compra**");
		for (Products produto : produtosEmCompra) {	
		   //System.out.println(i +"-"+produto.formatarProdutoMenu());
			
		   //teste
		   System.out.println(i +"-"+produto.formatarProduto());
		   
		   i++;
		}
		System.out.println("\n");
	}

	
	//Menu Insere Imposto no Produto
	
	public static Taxes menuImpostosInserirProduto(ArrayList<Taxes> impostos) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
				
		for (Taxes imposto : impostos) {	
			   System.out.println(i +"-"+imposto.formatarImposto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		return impostos.get(op);
	}
	
	//Menu atualiza Produto
	
	public static ArrayList<Products> menuAtualizaProduto(ArrayList<Products> produtos,ArrayList<Taxes> impostos) throws Exception {
		
		int produtoIndex = menuAttProdutoAux(produtos);
		
		Products produtoAtualizado = produtos.get(produtoIndex);
		
		produtos.set(produtoIndex, ProductsUtil.atualizaProdutos(produtoAtualizado, impostos));
		
		return produtos;
	}
	
	public static int menuAttProdutoAux(ArrayList<Products> produtos) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
		
		System.out.println("Escolha um produto para modificar: ");
		
		for (Products produto : produtos) {	
			   System.out.println(i +"-"+produto.formatarProduto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		
		return op;
	}
	
	//Menu atualiza Imposto
	
	public static ArrayList<Taxes> menuAtualizaImposto(ArrayList<Taxes> impostos) throws Exception{
		
		int impostoIndex = menuAtualizaImpostoAux(impostos);
		
		Taxes ImpostoAtualizado = impostos.get(impostoIndex);
		
		impostos.set(impostoIndex, TaxesUtil.atualizaImposto(ImpostoAtualizado));
		
		return impostos;
	}
	
	public static int menuAtualizaImpostoAux(ArrayList<Taxes> impostos) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
		
		System.out.println("Escolha um imposto para modificar: ");
		
		for (Taxes imposto : impostos) {	
			   System.out.println(i +"-"+imposto.formatarImposto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		return op;
	}

	//Menu Seleciona Produtos para vender
	
	public static ArrayList<Products> menuSeleciona(ArrayList<Products> produtos, ArrayList<Products> produtodoVenda){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		
		int op =1;
		
		do {
			
			Products produtoAuxiliar = menuSelecionaProdutoAux(produtos);
			
			produtodoVenda.add( produtoAuxiliar);
			
			System.out.println("Parar - 0 | Continuar - 1");
			op = scanner.nextInt();	
			
		} while (op != 0);
		
		return produtodoVenda;
	}
	
	public static Products menuSelecionaProdutoAux(ArrayList<Products> produtos) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
		
		System.out.println("Escolha um produto para inserir no carrinho: ");
		
		for (Products produto : produtos) {	
			   System.out.println(i +"-"+produto.formatarProduto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		
		return produtos.get(op);
	}
	
	//Menu Exclusao de Produtos
	
	public static ArrayList<Products> menuExcluirVendas(ArrayList<Products> produtodoVenda){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		
		int op =1;
		
		do {
			
			Products produtoAuxiliar = menuExcluirVendaProdutoAux(produtodoVenda);
			
			produtodoVenda.remove(produtoAuxiliar);
			
			System.out.println("Parar - 0 | Continuar - 1");
			op = scanner.nextInt();	
			
		} while (op != 0);
		
		return produtodoVenda;
	}
	public static Products menuExcluirVendaProdutoAux(ArrayList<Products> produtos) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int i = 1,op = 0;
		
		System.out.println("Escolha um produto para Excluir da lista de Compras: ");
		
		for (Products produto : produtos) {	
			   System.out.println(i +"-"+produto.formatarProduto());
			   i++;
			}
		op = scanner.nextInt();
		
		op--;
		
		
		return produtos.get(op);
	}
	
	//Menu Concluir 
	public static void menuConcluirVenda(ArrayList<Products> produtodoVenda){
				
		System.out.println("Venda Concluída!\n");

	    for (Products produto : produtodoVenda) {
	    	ProductsCalcs calculadora = new ProductsCalcs();
	        double precoFinal = calculadora.calculaPrecoFinal();
	        produto.setSalePrice(precoFinal);
	        System.out.println(produto.formatarProdutoUltimaListagem());
	        System.out.println("-------------------------");
	    }

	    double totalVenda = 0.0;
	    for (Products produto : produtodoVenda) {
	        totalVenda += produto.getPrecoVenda();
	    }

	    System.out.println("Total da Venda: R$" + totalVenda);
		
		
		
	}
	
}
