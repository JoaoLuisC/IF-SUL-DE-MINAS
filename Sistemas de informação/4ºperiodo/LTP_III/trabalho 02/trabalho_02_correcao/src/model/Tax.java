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

	
	private void setAliquot(double aliquot) {
		//TODO Implementar calculo do imposto
		this.aliquot = aliquot/100;
	}
	
	
	public double calculate() {
		return 0;
	}
}
