package view;
import java.util.ArrayList;
import java.util.Scanner;

import model.menus.Menu;
import model.menus.TestSetup;
import model.products.Products;
import model.products.util.ProductsUtil;
import model.taxes.Taxes;
import model.taxes.util.TaxesUtil;

public class Main {
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings({ "resource", "unused" })
		Scanner scanner = new Scanner(System.in);
	
		ArrayList<Taxes> impostos = new ArrayList<>();
		impostos = TestSetup.popularImpostos();
		
		ArrayList<Products> produtos = new ArrayList<>();
		produtos = TestSetup.popularProdutos(impostos);

		ArrayList<Products> produtosCompra = new ArrayList<>();
		
		int op = Menu.menuPrincipal();
		
		do {
			switch (op) {
				
				//Listar Produtos e Listas
				case 1: 
					Menu.menuProdutoListar(produtos);
					Menu.menuImpostosListar(impostos);
				break;
				
				case 2: 
					ProductsUtil.insereProdutos(produtos,impostos);	
				break;
				
				case 3: 
					TaxesUtil.insereImposto(impostos);					
				break;
				
				case 4: 
					Menu.menuAtualizaProduto(produtos, impostos);
				break;
				
				case 5: 
					Menu.menuAtualizaImposto(impostos);
				break;
				
				case 6: 
					produtosCompra =  Menu.menuSeleciona(produtos,produtosCompra);
				break;
				
				case 7: 
					Menu.menuCompraListar(produtosCompra);	
				break;
				
				case 8: 
					produtosCompra = Menu.menuExcluirVendas(produtosCompra);
				break;
				
				case 9: 
					Menu.menuConcluirVenda(produtosCompra);
					System.exit(0);
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
