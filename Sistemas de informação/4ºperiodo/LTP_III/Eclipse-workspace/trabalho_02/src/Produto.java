import java.util.Scanner;;

public class Produto {
	// variaveis: nomeProduto, Preço Custo, margem de lucro

	private double precoCusto;
	private String nomeProduto;
	private double margemLucro;

	
	// GETTERS dos Produtos
	public double getPrecoCusto() {
		return precoCusto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public double getMargemLucro() {
		return margemLucro;
	}

	public void setPrecoCusto(double precoCusto2) {
		this.precoCusto = precoCusto2;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public void setMargemLucro(double margemLuro) {
		this.margemLucro = margemLuro;
	}

	// metodos Para calcular o preço final do produto com base nos impostos e margem
	// de lucro
	public double calculaPrecoFinal(double impostosSomados, double margemLucro, double precoCusto) {

		double precoFinal;

		double preçoCustoFinal = precoCusto + (precoCusto * impostosSomados);

		precoFinal = preçoCustoFinal * margemLucro;

		return precoFinal;
	}

	// metodo de StringFormat para devolver strings formatadas
	public String formatarProduto() {
		return String.format("Produto: %s | Preço Custo: %.2f | Margem Lucro: %.0f%%" 
														,nomeProduto, precoCusto,margemLucro);
	}
	
	// metodo de StringFormat para devolver strings formatadas para o menu_
	public String formatarProdutoMenu() {
		return String.format(nomeProduto);
	}
	
	//metodo para inserir os dados dos produtos
	public static Produto[] insereProdutos(int tamanho) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		Produto[] produtos = new Produto[tamanho];
		
		for (int i = 0; i < produtos.length; i++) {

			Produto produto = new Produto();

			System.out.println("Digite o nome do Produto " + (i + 1) + ":");
			String nomeProduto = scanner.nextLine();
			produto.setNomeProduto(nomeProduto);

			System.out.println("Digite o Preço de Custo do Produto " + (i + 1) + ":");
			double precoCusto = scanner.nextDouble();
			produto.setPrecoCusto(precoCusto);

			System.out.println("Digite a Margem de Lucro em porcentagem do Produto " + (i + 1) + ":");
			double margemLucro = scanner.nextDouble();
			produto.setMargemLucro(margemLucro);

			produtos[i] = produto;

		}
		
		return produtos;

	}
}
