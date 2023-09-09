package model.taxes.types;

import model.products.Products;
import model.taxes.Taxes;

public class Ipi extends Taxes{

	
	public void validatesNationality(Products produto) {
		if(produto.isNational()) 
			setTaxAliquot(8.0);	
		else 
			setTaxAliquot(10.0);
	}

}
