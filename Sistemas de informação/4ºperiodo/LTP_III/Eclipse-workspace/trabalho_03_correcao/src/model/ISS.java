package model;

public class ISS extends Tax {

	private static final double ALIQUOT = 5;

	public ISS() throws Exception {
		super("ISS", "Imposto sobre serviço");
	}

	@Override
	public void defineAliquot(Product p) {
		setAliquot(ALIQUOT);
	}

	@Override
	public double calculate(Product p) {
		double salePrice = p.getCostPrice() + (p.getCostPrice() * p.getProfit());
		double iss = salePrice * getAliquot();
		return iss;
	}

}
