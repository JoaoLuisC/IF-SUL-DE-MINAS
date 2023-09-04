package model;

public class Tax {
	
	private String abbr;
	private String name;
	private double aliquot;
	
	
	public Tax(String abbr, String name, double aliquot) {
		//TODO devemos validar os atributos
		this.abbr = abbr;
		this.name = name;
		setAliquot(aliquot);
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(obj == null)
			return false;
		if(!(obj instanceof Tax))
			return false;
		
		//Cast (Tax)obj
		Tax tax = (Tax)obj;
		
		return this.abbr.equals(tax.abbr);
	}
	
	private void setAliquot(double aliquot) {
		//TODO Implementar calculo do imposto
		this.aliquot = aliquot/100;
	}
	
	
	public double calculate() {
		return 0;
	}
}
