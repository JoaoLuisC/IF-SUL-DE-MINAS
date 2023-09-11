package model.products;

import java.util.ArrayList;

import model.taxes.Taxes;
import model.taxes.types.Icms;
import model.taxes.types.Ipi;

public class Products {

	private double costPrice;
	private String productName;
	private double profitMargin;
	private double salePrice;
	private boolean isNational;
	private ArrayList<Taxes> taxes;

	// CONSTRUTOR
	public Products() {

	}

	public Products(double precoCusto, String nomeProduto, double margemLucro,boolean isNational) throws Exception {
		super();
		setPrecoCusto(precoCusto);
		setNomeProduto(nomeProduto);
		setMargemLucro(margemLucro);
		this.isNational = isNational;
		this.taxes = new ArrayList<>();
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

	public boolean getIsNational() {
		return isNational;
	}

	// SETTERS de Produtos
	public void setSalePrice(double precoVenda) {
		this.salePrice = precoVenda;
	}

	public void setTaxes(ArrayList<Taxes> tax) throws Exception {
				
		for (Taxes imposto : tax) {
	        if (imposto.getAbbr().equalsIgnoreCase("IPI")) { 
	            imposto.setTaxAliquot(this.getIsNational() ? 10.0 : 8.0); 
	            break;
	        }
	    }
		
		if (hasICMS(tax) == true && hasIPI()==true) {
	        for (Taxes imposto : tax) {
	            if (imposto.getAbbr().equalsIgnoreCase("ICMS")) {
	                imposto.setTaxAliquot(7.0); 
	            }
	        }
	    }
			
		this.taxes = tax;
		
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
	
	public boolean addTax(Taxes tax) throws Exception {

		if (tax == null)
			throw new Exception("Imposto não pode ser nulo.");

		if (taxes.contains(tax))
			return false;
		else
			taxes.add(tax);

		return true;
	}
	
	public boolean hasIPI() {
	    for (Taxes imposto : taxes) {
	        if (imposto.getAbbr().equalsIgnoreCase("IPI")) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean hasICMS(ArrayList<Taxes> tax) {
	    for (Taxes imposto : tax) {
	        if (imposto.getAbbr().equalsIgnoreCase("ICMS")) {
	            return true;
	        }
	    }
	    return false;
	}
	
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

		String nacionalidade = isNational ? "Nacional" : "Importado"; // Verifica se é nacional ou importado

		return String.format("Produto: %s | Preço Custo: R$%.2f | Margem Lucro: %.0f%% | Nacionalidade: %s\n%s",
				productName, costPrice, profitMargin, nacionalidade, impostosFormatados.toString());
	}

	// metodo de StringFormat para devolver strings formatadas na ultima listagem
	public String formatarProdutoUltimaListagem() {
		StringBuilder impostosFormatados = new StringBuilder();
		if (taxes != null && !taxes.isEmpty()) {
			impostosFormatados.append("   Impostos: ");
			for (Taxes imposto : taxes) {
				impostosFormatados.append(imposto.getAbbr()).append(", ");
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
