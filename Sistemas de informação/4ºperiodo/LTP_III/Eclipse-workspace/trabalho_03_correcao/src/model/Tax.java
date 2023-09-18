package model;

public abstract class Tax {	
	
	private String abbr, name;
	private double aliquot;

	public Tax(String abbr, String name) throws Exception {
		this.abbr = abbr;
		this.name = name;
	}
	
	//SETTERS
	public void setName(String name) throws Exception {

		if (name == null || name.equals(""))
			throw new Exception("Nome Inválido!");

		this.name = name;
	}

	public void setAbbr(String abbr) throws Exception {

		if (abbr == null || abbr.equals(""))
			throw new Exception("Sigla Inválida!");

		this.abbr = abbr;
	}
	
	protected void setAliquot(double aliquot) {
		this.aliquot = aliquot / 100;
	}
	
	
	//GETTERS
	protected double getAliquot() {
		return this.aliquot;
	}
	
	//METODOS
	public abstract double calculate(Product p);
	public abstract void defineAliquot(Product p); 

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Tax))
			return false;

		Tax tax = (Tax) obj;

		return this.abbr.equals(tax.abbr);
	}
	
}