package model.taxes.types;

import model.taxes.Taxes;

public class Iss extends Taxes{

	public void valuesIss() throws Exception {
		setAbbr("ISS   ");
		setTaxName("Imposto sobre Serviços de Qualquer Natureza");
		setTaxAliquot(7.0);	
	}

}
