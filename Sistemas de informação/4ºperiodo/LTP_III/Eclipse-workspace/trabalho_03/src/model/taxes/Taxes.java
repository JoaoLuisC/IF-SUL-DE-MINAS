package model.taxes;

public class Taxes {

	private double aliquot;
	private String name, abbr;

	// Construtor
	public Taxes() {

	}

	public Taxes(String abbr, String name, double aliquot) throws Exception {
		super();
		setAbbr(abbr);
		setTaxName(name);
		setTaxAliquot(aliquot);
	}

	// GETTERS imposto
	public double getTaxAliquot() {
		return aliquot;
	}

	public String getTaxName() {
		return name;
	}

	public String getAbbr() {
		return abbr;
	}

	// SETTERS imposto
	public void setTaxAliquot(double taxaImposto) {
		this.aliquot = taxaImposto;
	}

	public void setTaxName(String nomeImposto) throws Exception {
		if (nomeImposto == null || nomeImposto.equals(""))
			throw new Exception("Nome Inválido!");

		this.name = nomeImposto;
	}

	public void setAbbr(String abbr) throws Exception {

		if (abbr == null || abbr.equals(""))
			throw new Exception("Sigla Inválida!");

		this.abbr = abbr;
	}

	// metodo equals
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Taxes))
			return false;

		Taxes tax = (Taxes) obj;

		return this.abbr.equals(tax.abbr);
	}

	// StringFormat do imposto
	public String formatarImposto() {
		return String.format(" %s | %s : %.0f%%", abbr, name, aliquot);
	}
}