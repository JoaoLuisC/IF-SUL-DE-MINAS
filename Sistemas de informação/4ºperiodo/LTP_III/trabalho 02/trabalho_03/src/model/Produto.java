package model;
import java.util.ArrayList;
import java.util.Scanner;

import model.imposto.Imposto;;

public class Produto {
	
	private double precoCusto;
	private String nomeProduto;
	private double margemLucro;
	private double precoVenda;
	private ArrayList<Imposto> impostos;

	//CONSTRUTOR
	public Produto() {
		
	}
	
	public Produto(double precoCusto, String nomeProduto, double margemLucro) {
		super();
		this.precoCusto = precoCusto;
		this.nomeProduto = nomeProduto;
		this.margemLucro = margemLucro;
	}
	
	// GETTERS dos Produtos

	public double getPrecoVenda() {
		return precoVenda;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public double getMargemLucro() {
		return margemLucro;
	}
	public ArrayList<Imposto> getImpostos() {
		return impostos;
	}
	
	//SETTERS de Produtos
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public void setImpostos(ArrayList<Imposto> impostos) {
		this.impostos = impostos;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public void setMargemLucro(double margemLuro) {
		this.margemLucro = margemLuro;
	}

	//----------------------------------------------------------------------------------
	
	// metodos Para calcular o preço final do produto com base nos impostos e margem
	// de lucro
	public double calculaPrecoFinal() {

		 double impostosSomados = Imposto.SomaImpostos(this);
		 double precoCustoFinal = precoCusto + (impostosSomados * precoCusto / 100);
		 double precoFinal = precoCustoFinal + (precoCustoFinal * margemLucro / 100);
		
		return precoFinal;
	}

	// metodo de StringFormat para devolver strings formatadas(usei o gpt nesse metodo)
	public String formatarProduto() {
	    StringBuilder impostosFormatados = new StringBuilder();
	    if (impostos != null && !impostos.isEmpty()) {
	        impostosFormatados.append("   Impostos: ");
	        for (Imposto imposto : impostos) {
	            impostosFormatados.append(imposto.getNomeImposto()).append(" (").append(imposto.getTaxaImposto()).append("%), ");
	        }
	        // Remover a vírgula e o espaço extras no final
	        impostosFormatados.setLength(impostosFormatados.length() - 2);
	    }

	    return String.format("Produto: %s | Preço Custo: R$%.2f | Margem Lucro: %.0f%%\n%s",
	                         nomeProduto, precoCusto, margemLucro, impostosFormatados.toString());
	}

	//metodo de StringFormat para devolver strings formatadas na ultima listagem
	public String formatarProdutoUltimaListagem() {
	    StringBuilder impostosFormatados = new StringBuilder();
	    if (impostos != null && !impostos.isEmpty()) {
	        impostosFormatados.append("   Impostos: ");
	        for (Imposto imposto : impostos) {
	            impostosFormatados.append(imposto.getNomeImposto()).append(", ");
	        }
	        // Remover a vírgula e o espaço extras no final
	        impostosFormatados.setLength(impostosFormatados.length() - 2);
	    }

	    return String.format("Produto: %s | %s |\n Preço de Venda: R$%.0f",
	                         nomeProduto, impostosFormatados.toString(),precoVenda);
	}
	// metodo de StringFormat para devolver strings formatadas para o menu_
	public String formatarProdutoMenu() {
		return String.format(nomeProduto);
	}
	
	//metodo para inserir os dados dos produtos
	public static ArrayList<Produto> insereProdutos(ArrayList<Produto> produtos,ArrayList<Imposto> impostos ) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		
		ArrayList<Imposto> impostosSelecionados = new ArrayList<>();
		
		Produto produto = new Produto();

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
		
	    produto.setImpostos(impostosSelecionados);
		
		produtos.add(produto);

		
		return produtos;

	}

	public static Produto atualizaProdutos(Produto produtoATT,ArrayList<Imposto> impostos ) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		
		ArrayList<Imposto> impostosSelecionados = new ArrayList<>();
		
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
		
	    produtoATT.setImpostos(impostosSelecionados);

		return produtoATT;

	}

}
