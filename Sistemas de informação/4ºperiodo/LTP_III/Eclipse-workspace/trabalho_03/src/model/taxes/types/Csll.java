package model.taxes.types;

import model.taxes.Taxes;

public class Csll extends Taxes {

	public void valuesCsll() throws Exception {
		setAbbr("CSLL  ");
		setTaxName("Contribuição Social sobre o Lucro Líquido");
		setTaxAliquot(4.0);
	}

}
