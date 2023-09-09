package model.taxes.calculations;

import java.util.ArrayList;

import model.products.Products;
import model.taxes.Taxes;

public class TaxesCalcs extends Taxes{

	public static double SomaImpostos(Products produto) {

		double somaImpostos = 0.0;

		ArrayList<Taxes> impostosDoProduto = produto.getImpostos();
		
		
		if (impostosDoProduto != null) {
	        for (Taxes imposto : impostosDoProduto) {
	            somaImpostos += imposto.getTaxAliquot();
	        }
	    }

		return somaImpostos;
	}

}
