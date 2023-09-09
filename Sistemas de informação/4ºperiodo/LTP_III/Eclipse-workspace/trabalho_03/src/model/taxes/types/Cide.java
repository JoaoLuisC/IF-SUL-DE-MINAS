package model.taxes.types;

import model.taxes.Taxes;

public class Cide extends Taxes{

	public void valuesCide() throws Exception{
		setAbbr("CIDE  ");
		setTaxName("Contribuição de Intervenção no Domínio Econômico");
		setTaxAliquot(10.0);
	}

}
