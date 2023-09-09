package model.products;

import java.util.ArrayList;

import model.taxes.Taxes;

public class Products {

	private double costPrice;
	private String productName;
	private double profitMargin;
	private double salePrice;
	private ArrayList<Taxes> taxes;
	private boolean isNational;

	// CONSTRUTOR
	public Products() {

	}

	
	public Products(double precoCusto, String nomeProduto, double margemLucro, ArrayList<Taxes> taxes)
			throws Exception {
		super();
		setPrecoCusto(precoCusto);
		setNomeProduto(nomeProduto);
		setMargemLucro(margemLucro);
		setTax(taxes);
	}

	// GETTERS dos Produtos

	public double getPrecoVenda() {
		return salePrice;
	}

	public double getPrecoCusto() {
		return costPrice;
	}

	public String getNomeProduto() {
		return productName;
	}

	public double getMargemLucro() {
		return profitMargin;
	}

	public ArrayList<Taxes> getImpostos() {
		return taxes;
	}

	// SETTERS de Produtos
	public void setSalePrice(double precoVenda) {
		this.salePrice = precoVenda;
	}

	public void setTax(ArrayList<Taxes> tax) throws Exception {

		if (tax == null)
			throw new Exception("Imposto não pode ser nulo.");
		
		if (this.taxes == null) {
	        this.taxes = new ArrayList<>(); // Inicialize a lista se for nula
	    }

		for (Taxes t : tax) {
			if (taxes.contains(t)) {
				throw new Exception("Imposto já contido no produto.");
			}
		}

		this.taxes.addAll(tax);
	}

	public void setPrecoCusto(double precoCusto) throws Exception {

		if (precoCusto <= 0)
			throw new Exception("Preço de custo está inválido!");

		this.costPrice = precoCusto;
	}

	public void setNomeProduto(String name) throws Exception {
		if (name == null || name.equals(""))
			throw new Exception("Nome Inválido!");

		this.productName = name;
	}

	public void setMargemLucro(double profit) throws Exception {

		if (profit <= 0)
			throw new Exception("Margem está Inválida!");

		this.profitMargin = profit;
	}

	public void setNational(boolean isNational) {
		this.isNational = isNational;
	}

	// ----------------------------------------------------------------------------------

	// metodo de StringFormat para devolver strings formatadas(usei o gpt nesse
	// metodo)
	public String formatarProduto() {
		StringBuilder impostosFormatados = new StringBuilder();
		if (taxes != null && !taxes.isEmpty()) {
			impostosFormatados.append("  Impostos: ");
			for (Taxes imposto : taxes) {
				impostosFormatados.append(imposto.getAbbr()).append(" (").append(imposto.getTaxAliquot())
						.append("%), ");
			}
			// Remover a vírgula e o espaço extras no final
			impostosFormatados.setLength(impostosFormatados.length() - 2);
		}

		return String.format("Produto: %s | Preço Custo: R$%.2f | Margem Lucro: %.0f%%\n%s", productName, costPrice,
				profitMargin, impostosFormatados.toString());
	}

	// metodo de StringFormat para devolver strings formatadas na ultima listagem
	public String formatarProdutoUltimaListagem() {
		StringBuilder impostosFormatados = new StringBuilder();
		if (taxes != null && !taxes.isEmpty()) {
			impostosFormatados.append("   Impostos: ");
			for (Taxes imposto : taxes) {
				impostosFormatados.append(imposto.getTaxName()).append(", ");
			}
			// Remover a vírgula e o espaço extras no final
			impostosFormatados.setLength(impostosFormatados.length() - 2);
		}

		return String.format("Produto: %s | %s |\n Preço de Venda: R$%.0f", productName, impostosFormatados.toString(),
				salePrice);
	}

	// metodo de StringFormat para devolver strings formatadas para o menu_
	public String formatarProdutoMenu() {
		return String.format(productName);
	}

}
