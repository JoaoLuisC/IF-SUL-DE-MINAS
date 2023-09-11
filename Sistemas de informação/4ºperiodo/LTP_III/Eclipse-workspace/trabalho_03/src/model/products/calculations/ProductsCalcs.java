package model.products.calculations;

import model.products.Products;
import model.taxes.calculations.TaxesCalcs;

public class ProductsCalcs extends Products {

	// metodos Para calcular o preço final do produto com base nos impostos e margem
	// de lucro
	public double calculaPrecoFinal(Products produto) {

		double impostosSomados = TaxesCalcs.SomaImpostos(produto);
		double precoCustoFinal = produto.getPrecoCusto() + (impostosSomados * produto.getPrecoCusto() / 100);
		double precoFinal = precoCustoFinal + (precoCustoFinal * produto.getMargemLucro() / 100);
		
		return precoFinal;
	}

	

}
