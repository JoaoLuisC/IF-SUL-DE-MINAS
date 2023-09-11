package model.products.util;

import java.util.ArrayList;
import java.util.Scanner;

import model.menus.Menu;
import model.products.Products;
import model.taxes.Taxes;

public class ProductsUtil extends Products {

	// metodo para inserir os dados dos produtos
	public static ArrayList<Products> insereProdutos(ArrayList<Products> produtos, ArrayList<Taxes> impostos)
			throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		ArrayList<Taxes> impostosSelecionados = new ArrayList<>();
		Products produto = new Products();

		System.out.println("Digite o nome do Produto:\n");
		String nomeProduto = scanner.nextLine();
		if (produtoDuplicado(produtos, nomeProduto)) {
			throw new Exception("Já existe um produto com o mesmo nome.");
		}
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

			Taxes imposto = Menu.menuImpostosInserirProduto(impostos);
			if (impostoDuplicado(impostosSelecionados, imposto)) {
				throw new Exception("Este imposto já foi selecionado para o produto.");
			}

			impostosSelecionados.add(imposto);

			numImpostos--;

		} while (numImpostos != 0);

		System.out.println("Digite [1] para produto nacional ou [2] para produto internacional");
		int isNational = scanner.nextInt();
		if (isNational == 1)
			produto.setNational(true);
		else
			produto.setNational(false);

		produto.setTaxes(impostosSelecionados);
		produtos.add(produto);

		return produtos;

	}

	public static Products atualizaProdutos(Products produtoATT, ArrayList<Taxes> impostos) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		produtoATT.getImpostos().clear();

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

			Taxes imposto = Menu.menuImpostosInserirProduto(impostos);
			if (impostoDuplicado(impostosSelecionados, imposto)) {
				throw new Exception("Este imposto já foi selecionado para o produto.");
			}

			impostosSelecionados.add(imposto);

			numImpostos--;

		} while (numImpostos != 0);

		System.out.println("Digite [1] para produto nacional ou [2] para produto internacional");
		int isNational = scanner.nextInt();
		if (isNational == 1)
			produtoATT.setNational(true);
		else
			produtoATT.setNational(false);

		produtoATT.setTaxes(impostosSelecionados);

		return produtoATT;

	}

	private static boolean produtoDuplicado(ArrayList<Products> produtos, String nomeProduto) {
		for (Products produto : produtos) {
			if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
				return true;
			}
		}
		return false;
	}

	private static boolean impostoDuplicado(ArrayList<Taxes> impostos, Taxes imposto) {
		for (Taxes tax : impostos) {
			if (tax.getTaxName().equalsIgnoreCase(imposto.getTaxName())) {
				return true;
			}
		}
		return false;
	}

}
