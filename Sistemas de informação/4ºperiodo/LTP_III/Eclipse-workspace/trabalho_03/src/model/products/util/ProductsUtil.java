package model.products.util;

import java.util.ArrayList;
import java.util.Scanner;

import model.menus.Menu;
import model.products.Products;
import model.taxes.Taxes;

public class ProductsUtil extends Products{

	//metodo para inserir os dados dos produtos
		public static ArrayList<Products> insereProdutos(ArrayList<Products> produtos,ArrayList<Taxes> impostos ) throws Exception {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);		
			
			ArrayList<Taxes> impostosSelecionados = new ArrayList<>();
			
			Products produto = new Products();

			System.out.println("Digite o nome do Produto:\n");
			String nomeProduto = scanner.nextLine();
			produto.setNomeProduto(nomeProduto);

			System.out.println("Digite o Preço de Custo do Produto:\n");
			double precoCusto = scanner.nextDouble();
			produto.setPrecoCusto(precoCusto);

			System.out.println("Digite a Margem de Lucro em porcentagem do Produto:\n ");
			double margemLucro = scanner.nextDouble();
			produto.setMargemLucro(margemLucro);
			
			System.out.println("Digite o número do impostos para este produto:");
		    int numImpostos = scanner.nextInt();
		    do {
		    	System.out.println("Escolha o Imposto");
		    	
		    	impostosSelecionados.add(Menu.menuImpostosInserirProduto(impostos));
			    	
		    	numImpostos --;
		    	
			} while (numImpostos!=0);
			
		    produto.setTax(impostosSelecionados);
			
			produtos.add(produto);

			
			return produtos;

		}

		public static Products atualizaProdutos(Products produtoATT,ArrayList<Taxes> impostos ) throws Exception {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);		
			
			ArrayList<Taxes> impostosSelecionados = new ArrayList<>();
			
			System.out.println("Digite o nome do Produto:\n");
			String nomeProduto = scanner.nextLine();
			produtoATT.setNomeProduto(nomeProduto);

			System.out.println("Digite o Preço de Custo do Produto:\n");
			double precoCusto = scanner.nextDouble();
			produtoATT.setPrecoCusto(precoCusto);

			System.out.println("Digite a Margem de Lucro em porcentagem do Produto:\n ");
			double margemLucro = scanner.nextDouble();
			produtoATT.setMargemLucro(margemLucro);
			
			System.out.println("Digite o número do impostos para este produto:");
		    int numImpostos = scanner.nextInt();
		    do {
		    	System.out.println("Escolha o Imposto");
		    	
		    	impostosSelecionados.add(Menu.menuImpostosInserirProduto(impostos));
			    	
		    	numImpostos --;
		    	
			} while (numImpostos!=0);
			
		    produtoATT.setTax(impostosSelecionados);

			return produtoATT;

		}

}
