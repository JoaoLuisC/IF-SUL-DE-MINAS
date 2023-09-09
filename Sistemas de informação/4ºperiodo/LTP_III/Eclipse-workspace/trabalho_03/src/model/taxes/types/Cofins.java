package model.taxes.types;

import model.taxes.Taxes;

public class Cofins extends Taxes{

	public void valuesCofins() throws Exception {
		setAbbr("COFINS");
		setTaxName("Contribuição para o Financiamento da Seguridade Social");
		setTaxAliquot(12.0);	
	}

}
