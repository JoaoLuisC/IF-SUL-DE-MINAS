package model.products.calculations;

import model.products.Products;
import model.taxes.calculations.TaxesCalcs;

public class ProductsCalcs extends Products{

	// metodos Para calcular o preço final do produto com base nos impostos e margem
		// de lucro
		public double calculaPrecoFinal() {

			 double impostosSomados = TaxesCalcs.SomaImpostos(this);
			 double precoCustoFinal = getPrecoCusto() + (impostosSomados * getPrecoCusto() / 100);
			 double precoFinal = precoCustoFinal + (precoCustoFinal * getMargemLucro() / 100);
			
			return precoFinal;
		}
		
		public void verifyTax() {
			
		}

}
