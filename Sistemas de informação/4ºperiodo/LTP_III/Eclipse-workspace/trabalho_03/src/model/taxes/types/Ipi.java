package model.taxes.types;

import model.taxes.Taxes;

public class Ipi extends Taxes{

	public void valuesIpi() throws Exception {
		setAbbr("IPI   ");
		setTaxName("Imposto sobre Serviços de Qualquer Natureza");
		setTaxAliquot(5.0);	
	}

}
