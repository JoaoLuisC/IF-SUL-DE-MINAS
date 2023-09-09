package model.taxes.types;

import model.taxes.Taxes;

public class Icms extends Taxes{

	public void valuesIcms() throws Exception{
		setAbbr("ICMS  ");
		setTaxName("Imposto sobre Circulação de Mercadorias e Serviços");
		setTaxAliquot(7.0);		
	}

}
